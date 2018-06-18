package com.example.ssh.Pojo;

public class Student {
	private Integer st_id;
	private String  st_name;
	private String  st_sex;
	private String  st_mail;
	private String  st_phone;
	private String  st_address;
	private com.example.ssh.Pojo.Class  class1;
	@Override
	public String toString() {
		return "Student [st_id=" + st_id + ", st_name=" + st_name + ", st_sex=" + st_sex + ", st_mail=" + st_mail
				+ ", st_phone=" + st_phone + ", st_address=" + st_address + ", class1=" + class1 + "]";
	}
	public Integer getSt_id() {
		return st_id;
	}
	public void setSt_id(Integer st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_sex() {
		return st_sex;
	}
	public void setSt_sex(String st_sex) {
		this.st_sex = st_sex;
	}
	public String getSt_mail() {
		return st_mail;
	}
	public void setSt_mail(String st_mail) {
		this.st_mail = st_mail;
	}
	public String getSt_phone() {
		return st_phone;
	}
	public void setSt_phone(String st_phone) {
		this.st_phone = st_phone;
	}
	public String getSt_address() {
		return st_address;
	}
	public void setSt_address(String st_address) {
		this.st_address = st_address;
	}
	public com.example.ssh.Pojo.Class getClass1() {
		return class1;
	}
	public void setClass1(com.example.ssh.Pojo.Class class1) {
		this.class1 = class1;
	}
	

}
