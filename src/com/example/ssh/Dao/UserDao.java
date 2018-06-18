package com.example.ssh.Dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.example.ssh.Pojo.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserDao  extends HibernateDaoSupport{
	

	public User findByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		System.out.println("开始执行登录验证.....");
		String hqlString = "from User where u_usename= ? and u_password= ? ";
		System.out.println(hqlString);
		List<User> list =this.getHibernateTemplate().find(hqlString,user.getU_usename(),user.getU_password());
		System.out.println("12"+list.size());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public boolean save(User users) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的保存用户信息被执行了.....");
		this.getHibernateTemplate().save(users);
		boolean rs = true;
		return rs;
		
		
	} 

}
