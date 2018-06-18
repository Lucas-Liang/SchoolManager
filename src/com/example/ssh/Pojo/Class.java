package com.example.ssh.Pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * —ß…˙¿‡
*<p>Title: Class</p>
*<p>Description: </p>
*<p>Company: </p> 
*@author * @date
 */
public class Class {
	private Integer c_id;
	private String  c_name;
	private String  c_info;
	private School  school;
	private Set<Student> student = new HashSet<Student>();
	
	
	
	
	public Set<Student> getStudent() {
		return student;
	}


	public void setStudent(Set<Student> student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Class [c_id=" + c_id + ", c_name=" + c_name + ", c_info=" + c_info + ", school=" + school + ", student="
				+ student + "]";
	}
	
	
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_info() {
		return c_info;
	}
	public void setC_info(String c_info) {
		this.c_info = c_info;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	
	 
	
	
	

}
