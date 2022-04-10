package data;

import java.io.Serializable;

public class test implements Serializable {
	private int kysymys_id;
	private String kysymys;
	
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public String toString() {
		return kysymys_id+" "+kysymys;
	}
	
	
}
