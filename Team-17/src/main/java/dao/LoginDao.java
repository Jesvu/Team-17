package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	public boolean validate(String name, String pass) {
		boolean status = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "appuser", "kukkuu");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM LOGIN WHERE username=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			status=rs.next();
		} 
		catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {System.out.println(e);}
			return status;
	}
}
	