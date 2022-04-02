package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao
{
	private Connection conn;
	
	public LoginDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
<<<<<<< Updated upstream
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
=======
			conn=java.sql.DriverManager.getConnection("jbc:mysql://localhost:3306/gamedb", "appuser", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void AddUser(String username, String pw, String salt) {
		String sql = "insert into useraccount (username, hashedpassword, salt) values (?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, pw);
			stmt.setString(3, salt);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
>>>>>>> Stashed changes
	}
	
	
	
}