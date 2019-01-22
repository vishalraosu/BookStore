package com.softvision.BO;


public class AdminBO {
	private String adminname;
	private String adminpassword;
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	@Override
	public String toString() {
		return "AdminBO [adminname=" + adminname + ", adminpassword=" + adminpassword + "]";
	}
	
	
	
}