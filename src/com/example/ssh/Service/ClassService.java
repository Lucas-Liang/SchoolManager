package com.example.ssh.Service;

import java.util.List;

import com.example.ssh.Dao.ClassDao;
import com.example.ssh.Dao.SchoolDao;
import com.example.ssh.Pojo.Class;
import com.example.ssh.Pojo.IndexPage;
import com.example.ssh.Pojo.School;

public class ClassService {
	private ClassDao classDao;

	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	/**
	 * ∑÷“≥≤È—Ø
	 * @param indexPage
	 * @return
	 */
	public IndexPage<com.example.ssh.Pojo.Class> findByPage(Integer indexPage) {
		// TODO Auto-generated method stub
		IndexPage<com.example.ssh.Pojo.Class> inPage =new IndexPage<com.example.ssh.Pojo.Class>();
		inPage.setIndexPage(indexPage);
		int pageSize=3;
		inPage.setPageSize(pageSize);
		int pageCount =classDao.findAllCount();
		inPage.setPageCount(pageCount);
		double num = pageCount;
		Double indexCount =  Math.ceil(num/pageSize);
		inPage.setIndexCount(indexCount.intValue());
		int begin = (indexPage-1)*pageSize;
		List<com.example.ssh.Pojo.Class> list = classDao.findByPage(begin,pageSize);
		
		inPage.setList(list);
		return inPage;
	}
	public IndexPage<com.example.ssh.Pojo.Class> findBySearch(String s_search, Integer indexPage) {
		// TODO Auto-generated method stub
		IndexPage<com.example.ssh.Pojo.Class> inPage =new IndexPage<com.example.ssh.Pojo.Class>();
		inPage.setIndexPage(indexPage);
		int pageSize=3;
		inPage.setPageSize(pageSize);
		int pageCount =classDao.findSearchCount(s_search);
		inPage.setPageCount(pageCount);
		double num = pageCount;
		Double indexCount =  Math.ceil(num/pageSize);
		inPage.setIndexCount(indexCount.intValue());
		int begin = (indexPage-1)*pageSize;
		List<com.example.ssh.Pojo.Class> list = classDao.findByPageSreach(begin,pageSize,s_search);
		inPage.setList(list);
		System.out.println("----------->"+inPage);
		return inPage;
	}
	public void add(com.example.ssh.Pojo.Class class1) {
		// TODO Auto-generated method stub
		classDao.add(class1);
		
	}
	public com.example.ssh.Pojo.Class findById(Integer s_id) {
		// TODO Auto-generated method stub
		return classDao.finById(s_id);
	}
	public void updata(com.example.ssh.Pojo.Class class1) {
		// TODO Auto-generated method stub
		System.out.println(class1);
		classDao.updata(class1);
		
	}
	public List<School> getSchoolList() {
		// TODO Auto-generated method stub
		return classDao.getSchoolList();
	}
	public void delete(com.example.ssh.Pojo.Class class1) {
		// TODO Auto-generated method stub
		classDao.delete(class1);
	}
	

}
