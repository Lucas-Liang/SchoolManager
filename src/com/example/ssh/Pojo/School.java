package com.example.ssh.Pojo;

import java.util.HashSet;
import java.util.Set;
import com.example.ssh.Pojo.Class;;

public class School {
	private Integer s_id;
	private String  s_name;
	private String  s_address;
	
	private Set<com.example.ssh.Pojo.Class> setClass;
	
	public Set<com.example.ssh.Pojo.Class> getSetClass() {
		return setClass;
	}
	public void setSetClass(Set<com.example.ssh.Pojo.Class> setClass) {
		this.setClass = setClass;
	}
	
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_address() {
		return s_address;
	}
	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	

}
