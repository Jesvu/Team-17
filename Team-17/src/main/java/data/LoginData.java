package data;

public class LoginData {
	private String uname;
	private String pass;
	
	public String getName() {
		return uname;
	}
	public void setName(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String toString() {
		return uname+" ("+pass+")";
	}
}
