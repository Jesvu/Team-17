package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	public static boolean validate(String name, String pass) {
		boolean status = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM useraccount WHERE username=? and hashedpassword=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			status=rs.next();
		} 
		catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {System.out.println(e);}
			return status;
	}
}
	