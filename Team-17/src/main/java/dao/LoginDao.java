package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao
{

	public boolean check(String uname, String pass)
	{
		
		String sql = "select * from login where username=? and password=?";
		
		try { 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				return true;
			}
				
		} catch (Exception e) {
			
				e.printStackTrace();
			}
		return false;
	}
}