package com.example.ssh.Action;

import org.springframework.ui.Model;

import com.example.ssh.Pojo.User;
import com.example.ssh.Service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User users = new User();
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return users;
	}
	
	public String login(){
		System.out.println("ManagerAction�е�login��ִ����.....");
		System.out.println("user�е�login��ִ����....."+users.toString());
		User user = userService.login(users);
		if(user==null){
//			��¼ʧ��
			this.addActionError("�û�����������󣡣�");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("User",user);
			return SUCCESS;
		}
	}
	public String save(){
		System.out.println("Save��ִ��");
		boolean rs = userService.save(users);
		if(rs){
			return "success_login";
		}else {
			return INPUT;
		}
		
	}

}
