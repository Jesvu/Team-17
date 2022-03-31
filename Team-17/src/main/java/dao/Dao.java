package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.Info;

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
				info.setId(rs.getInt("id"));
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


	public Info getInfoInfo(int id) {
		Info result = null;
		String sql = "select * from ehdokkaat where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet resultset = stmt.executeQuery();

			if (resultset.next()) {
				result = new Info();
				result.setId(resultset.getInt("id"));
				result.setSukunimi(resultset.getString("sukunimi"));
				result.setEtunimi(resultset.getString("etunimi"));
				result.setPuolue(resultset.getString("puolue"));
				result.setKotipaikkakunta(resultset.getString("kotipaikkakunta"));
				result.setIka(resultset.getInt("ika"));
				result.setMiksi_eduskuntaan(resultset.getString("miksi_eduskuntaan"));
				result.setMita_asioita_haluat_edistaa(resultset.getString("mita_asioita_haluat_edistaa"));
				result.setAmmatti(resultset.getString("ammatti"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}}



//String sql = "SELECT * FROM ehdokkaat";
//
//Statement statement = conn.createStatement();
//ResultSet result = statement.executeQuery(sql);
//
//int count = 0; {
//
//	while (result.next()) {
//		String id = result.getObject(1).toString();
//		String sukunimi = result.getObject(2).toString();
//		String etunimi = result.getObject(3).toString();
//		String puolue = result.getObject(4).toString();
//		String kotipaikkakunta = result.getObject(5).toString();
//		String ika = result.getObject(6).toString();
//		String miksi_eduskuntaan = result.getObject(7).toString();
//		String mita_asioita_haluat_edistaa = result.getObject(8).toString();
//		String ammatti = result.getObject(9).toString();
//		System.out.println(id + sukunimi + etunimi + puolue + kotipaikkakunta + ika + miksi_eduskuntaan
//				+ mita_asioita_haluat_edistaa + ammatti);
//	}}}}






