package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import app.Info;
import data.Kysymykset;

//import app.Info;
//import data.info;

public class Dao {
	private static Connection conn;
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
			                  
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
				info.setEhdokas_id(rs.getInt("ehdokas_id"));
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

	
	public Kysymykset updateKysymys(Kysymykset k) {
		try {
			String sql="update kysymykset set kysymys =? where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, k.getKysymys());
			pstmt.setInt(2, k.getKysymys_id());
			pstmt.executeUpdate();
		
		}
		catch(SQLException e) {
			
		}
		return readKysymykset(String.valueOf(k.getKysymys_id()));
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


	
	public int addCandidate(Info info) {
		Statement stmt=null;
		int count=0;
		try {

			String sql="insert into ehdokkaat (ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, i.getEhdokas_id());
			pstmt.setString(2, i.getSukunimi());
			pstmt.setString(3, i.getEtunimi());
			pstmt.setString(4, i.getPuolue());
			pstmt.setString(5, i.getKotipaikkakunta());
			pstmt.setInt(6, i.getIka());
			pstmt.setString(7, i.getMiksi_eduskuntaan());
			pstmt.setString(8, i.getMita_asioita_haluat_edistaa());
			pstmt.setString(9, i.getAmmatti());
			pstmt.executeUpdate();
		}

		return count;

}

		catch(SQLException e) {
			

			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values("+info.getEhdokas_id()+", '"+info.getSukunimi()+"', '"+info.getEtunimi()+"', '"+info.getPuolue()+"', '"+info.getKotipaikkakunta()+"', "+info.getIka()+", '"+info.getMiksi_eduskuntaan()+"', '"+info.getMita_asioita_haluat_edistaa()+"', '"+info.getAmmatti()+"')");
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return count;

	}

public ArrayList<Info> readAllCandidates() {
	ArrayList<Info> list=new ArrayList<>();
	Statement stmt=null;
	int count=0;
	try {
		stmt = conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
		while (rs.next()) {
			Info candidate=new Info();
			candidate.setEhdokas_id(rs.getInt("EHDOKAS_ID"));
			candidate.setSukunimi(rs.getString("SUKUNIMI"));
			candidate.setEtunimi(rs.getString("ETUNIMI"));
			candidate.setPuolue(rs.getString("PUOLUE"));
			candidate.setKotipaikkakunta(rs.getString("KOTIPAIKKAKUNTA"));
			candidate.setIka(rs.getInt("IKA"));
			candidate.setMiksi_eduskuntaan(rs.getString("MIKSI_EDUSKUNTAAN"));
			candidate.setMita_asioita_haluat_edistaa(rs.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
			candidate.setAmmatti(rs.getString("Ammatti"));
			list.add(candidate);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
public Info ReadAllCandidates(int ehdokas_id) {
	Info result = null;
	String sql = "select * from ehdokkaat where ehdokas_id = ?";
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
					
		stmt.setInt(1, ehdokas_id);
		
		ResultSet resultset = stmt.executeQuery();
		
		if (resultset.next()) {
			result = new Info();
			result.setEhdokas_id(resultset.getInt("EHDOKAS_ID"));
			result.setSukunimi(resultset.getString("SUKUNIMI"));
			result.setEtunimi(resultset.getString("ETUNIMI"));
			result.setPuolue(resultset.getString("PUOLUE"));
			result.setKotipaikkakunta(resultset.getString("KOTIPAIKKAKUNTA"));
			result.setIka(resultset.getInt("IKA"));
			result.setMiksi_eduskuntaan(resultset.getString("MIKSI_EDUSKUNTAAN"));
			result.setMita_asioita_haluat_edistaa(resultset.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
			result.setAmmatti(resultset.getString("AMMATTI"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}

public int updateCandidate(Info info) {
	int count = 0;
	String sql = "update ehdokkaat set SUKUNIMI = ?, ETUNIMI = ?, PUOLUE = ?, KOTIPAIKKAKUNTA= ? IKA = ?, MIKSI_EDUSKUNTAAN= ?, MITA_ASIOITA_HALUAT_EDISTAA= ?, AMMATTI = ? where EHDOKAS_ID = ?";
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, info.getSukunimi());
		stmt.setString(2, info.getEtunimi());
		stmt.setString(3, info.getPuolue());
		stmt.setString(4, info.getKotipaikkakunta());
		stmt.setInt(5, info.getIka());
		stmt.setString(6, info.getMiksi_eduskuntaan());
		stmt.setString(7, info.getMita_asioita_haluat_edistaa());
		stmt.setString(8, info.getAmmatti());
		stmt.setInt(9, info.getEhdokas_id());
		
		count = stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
}

public Info getCandidateInfo(int ehdokas_id) {
	Info result = null;
	String sql = "select * from ehdokkaat where EHDOKAS_ID = ?";
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
					
		stmt.setInt(1, ehdokas_id);
		
		ResultSet resultset = stmt.executeQuery();
		
		if (resultset.next()) {
			result = new Info();
			result.setEhdokas_id(resultset.getInt("EHDOKAS_ID"));
			result.setSukunimi(resultset.getString("SUKUNIMI"));
			result.setEtunimi(resultset.getString("ETUNIMI"));
			result.setPuolue(resultset.getString("PUOLUE"));
			result.setKotipaikkakunta(resultset.getString("KOTIPAIKKAKUNTA"));
			result.setIka(resultset.getInt("IKA"));
			result.setMiksi_eduskuntaan(resultset.getString("MIKSI_EDUSKUNTAAN"));
			result.setMita_asioita_haluat_edistaa(resultset.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
			result.setAmmatti(resultset.getString("AMMATTI"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}


}




	}
	public ArrayList<Info> readAllCandidates() {
		ArrayList<Info> list=new ArrayList<>();

}
	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list=new ArrayList<>();

		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Info candidate=new Info();
				candidate.setId(rs.getInt("EHDOKAS_ID"));
				candidate.setSukunimi(rs.getString("SUKUNIMI"));
				candidate.setEtunimi(rs.getString("ETUNIMI"));
				candidate.setPuolue(rs.getString("PUOLUE"));
				candidate.setKotipaikkakunta(rs.getString("KOTIPAIKKAKUNTA"));
				candidate.setIka(rs.getInt("IKA"));
				candidate.setMiksi_eduskuntaan(rs.getString("MIKSI_EDUSKUNTAAN"));
				candidate.setMita_asioita_haluat_edistaa(rs.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
				candidate.setAmmatti(rs.getString("Ammatti"));
				list.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Info getCandidateInfo(int ehdokas_id) {
		Info result = null;
		String sql = "select * from ehdokkaat where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
					
			stmt.setInt(1, ehdokas_id);
		
			ResultSet resultset = stmt.executeQuery();
		
			if (resultset.next()) {
				result = new Info();
				result.setId(resultset.getInt("EHDOKAS_ID"));
				result.setSukunimi(resultset.getString("SUKUNIMI"));
				result.setEtunimi(resultset.getString("ETUNIMI"));
				result.setPuolue(resultset.getString("PUOLUE"));
				result.setKotipaikkakunta(resultset.getString("KOTIPAIKKAKUNTA"));
				result.setIka(resultset.getInt("IKA"));
				result.setMiksi_eduskuntaan(resultset.getString("MIKSI_EDUSKUNTAAN"));
				result.setMita_asioita_haluat_edistaa(resultset.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
				result.setAmmatti(resultset.getString("AMMATTI"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int updateCandidate(Info candidate) {
		int count = 0;
		String sql = "update ehdokkaat set sukunimi = ?, etunimi = ?, puolue = ?, kotipaikkakunta = ? ika = ?, miksi_eduskuntaan = ?, mita_asioita_haluat_edistaa = ?, ammatti = ? where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
		
			stmt.setString(1, candidate.getSukunimi());
			stmt.setString(2, candidate.getEtunimi());
			stmt.setString(3, candidate.getPuolue());
			stmt.setString(4, candidate.getKotipaikkakunta());
			stmt.setInt(5, candidate.getIka());
			stmt.setString(6, candidate.getMiksi_eduskuntaan());
			stmt.setString(7, candidate.getMita_asioita_haluat_edistaa());
			stmt.setString(8, candidate.getAmmatti());
			stmt.setInt(9, candidate.getId());
		
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}

