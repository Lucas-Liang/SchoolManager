package com.example.ssh.Pojo;

public class User {
	private Integer u_id;
	private String u_usename;
	private String u_password;
	private String u_mail;
	private String u_phone;
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_usename=" + u_usename + ", u_password=" + u_password + ", u_mail=" + u_mail
				+ ", u_phone=" + u_phone + "]";
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_usename() {
		return u_usename;
	}
	public void setU_usename(String u_usename) {
		this.u_usename = u_usename;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	

}
