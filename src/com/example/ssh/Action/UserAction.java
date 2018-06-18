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
		System.out.println("ManagerAction中的login被执行了.....");
		System.out.println("user中的login被执行了....."+users.toString());
		User user = userService.login(users);
		if(user==null){
//			登录失败
			this.addActionError("用户名和密码错误！！");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("User",user);
			return SUCCESS;
		}
	}
	public String save(){
		System.out.println("Save被执行");
		boolean rs = userService.save(users);
		if(rs){
			return "success_login";
		}else {
			return INPUT;
		}
		
	}

}
