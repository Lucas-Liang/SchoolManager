package com.example.ssh.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ssh.Pojo.IndexPage;
import com.example.ssh.Pojo.School;
import com.example.ssh.Service.ClassService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;



public class ClassAction extends ActionSupport implements ModelDriven<com.example.ssh.Pojo.Class>{
	
	private com.example.ssh.Pojo.Class class1 =new com.example.ssh.Pojo.Class();
	private ClassService classService;
	private Integer IndexPage =1;
	
	@Override
	public com.example.ssh.Pojo.Class getModel() {
		// TODO Auto-generated method stub
		return class1;
	}
	public void setIndexPage(Integer indexPage) {
		IndexPage = indexPage;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public String findAll() {
		IndexPage<com.example.ssh.Pojo.Class> index = classService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	public String search() throws UnsupportedEncodingException {
		String c = ServletActionContext.getRequest().getParameter("c_search");   //获取用户名  
		String c_search = new String(c.getBytes("iso-8859-1"),"UTF-8");
		IndexPage<com.example.ssh.Pojo.Class> search = classService.findBySearch(c_search,IndexPage);
		ActionContext.getContext().getValueStack().push(search);
		return "search";
	}
	public String save() {
		String c = ServletActionContext.getRequest().getParameter("s_id");   //获取用户名  
//		String c_search = new String(c.getBytes("iso-8859-1"),"UTF-8");
		
		School school = new School();
		school.setS_id(Integer.parseInt(c));
		class1.setSchool(school);
		classService.add(class1);
		IndexPage<com.example.ssh.Pojo.Class> index = classService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	/**
	 * 跳转到添加学校的页面
	 * @return
	 */
	public String add() {
		return "add";
	}
	/**
	 * 根据Id来查询School
	 * @return
	 */
	public String edit() {
		String s = ServletActionContext.getRequest().getParameter("c_id");   //获取用户名  
		int c_id = Integer.parseInt(s);
		//		String s_search = new String(s.getBytes("iso-8859-1"),"UTF-8");
		class1 = classService.findById(c_id);
		return "edit";
	}
	public String update() {
		String c = ServletActionContext.getRequest().getParameter("s_id");   //获取用户名  
//		String c_search = new String(c.getBytes("iso-8859-1"),"UTF-8");
		School school = new School();
		school.setS_id(Integer.parseInt(c));
		class1.setSchool(school);

		classService.updata(class1);
		IndexPage<com.example.ssh.Pojo.Class> index = classService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		return "findAll";
	}
	
	public void  AjaxSchoolList() throws IOException{
//		com.example.ssh.Util.JsonUitl.writeJson(classService.getSchoolList().toString());//获取省份集合
		try {
		 JSONObject json=new JSONObject();
		 JSONArray jsonArray = new JSONArray();
		 List<School> list = classService.getSchoolList();
		 for (int i = 0; i < list.size(); i++) {
			 JSONObject jsonObject = new JSONObject();
			 jsonObject.put("s_id", list.get(i).getS_id());
			 jsonObject.put("s_name", list.get(i).getS_name());
			 jsonArray.put(i, jsonObject);
		}
		 json.put("school", jsonArray);
		 String result = json.toString();
		 ServletActionContext.getResponse().setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
		 ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
	     ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		 ServletActionContext.getResponse().getWriter().flush();
		 ServletActionContext.getResponse().getWriter().close();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	public String delete() {
//		String s = ServletActionContext.getRequest().getParameter("c_id");   //获取用户名  
//		int c_id = Integer.parseInt(s);
		IndexPage<com.example.ssh.Pojo.Class> index = classService.findByPage(IndexPage);
		ActionContext.getContext().getValueStack().push(index);
		classService.delete(class1);
		return "findAll";
	}
	
	

}
