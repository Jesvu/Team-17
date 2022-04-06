package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import app.Info;
import data.Kysymykset;

//import app.Info;
//import data.info;

public class Dao {
	private static Connection conn;
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "appuser", "kukkuu");
			                  
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}


	public ArrayList<Info> readAllInfo() {
		ArrayList<Info> list=new ArrayList<>();
		Statement stmt=null;
		int count = 0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Info info=new Info();
				info.setId(rs.getInt("ehdokas_id"));
				info.setSukunimi(rs.getString("sukunimi"));
				info.setEtunimi(rs.getString("etunimi"));
				info.setPuolue(rs.getString("puolue"));
				info.setKotipaikkakunta(rs.getString("kotipaikkakunta"));
				info.setIka(rs.getInt("ika"));
				info.setMiksi_eduskuntaan(rs.getString("miksi_eduskuntaan"));
				info.setMita_asioita_haluat_edistaa(rs.getString("mita_asioita_haluat_edistaa"));
				info.setAmmatti(rs.getString("ammatti"));
				list.add(info);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<Kysymykset> updateKysymys(Kysymykset k) {
		try {
			String sql="update kysymykset set kysymys =? where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, k.getKysymys());
			pstmt.setInt(2, k.getKysymys_id());
			pstmt.executeUpdate();
		
		}
		catch(SQLException e) {
			
		}
		return readAllKysymykset();
	}
	
	public ArrayList<Kysymykset> addKysymys(Kysymykset k) {
		try {
			String sql="insert into kysymykset (kysymys,kysymys_id) values(?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, k.getKysymys());
			pstmt.setInt(2, k.getKysymys_id());
			pstmt.executeUpdate();
			
		}
		catch(SQLException e) {
			
		}
		return readAllKysymykset();
	}
	
	
	public ArrayList<Kysymykset> deleteKysymykset(String id) {
		try {
			String sql="delete from kysymykset where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		
		}
		catch(SQLException e) {
			
		}
		return readAllKysymykset();
	}
	
	public ArrayList<Kysymykset> readAllKysymykset() {
		ArrayList<Kysymykset> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymykset");
			while (RS.next()){
				Kysymykset k=new Kysymykset();
				k.setKysymys_id(RS.getInt("kysymys_id"));
				k.setKysymys(RS.getString("kysymys"));
				list.add(k);
			}
			return list;
		}
		catch(SQLException s) {
			return null;
		}
	}
	

	public Kysymykset readKysymykset(String id) {
		Kysymykset k=null;
		try {
			String sql="select * from kysymykset where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				k=new Kysymykset();
				k.setKysymys_id(RS.getInt("kysymys_id"));
				k.setKysymys(RS.getString("kysymys"));
			}
			return k;
		}
		catch(SQLException e) {
			return null;
		}
	}
}

