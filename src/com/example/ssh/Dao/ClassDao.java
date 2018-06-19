package com.example.ssh.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.example.ssh.Pojo.School;
import com.example.ssh.Service.SchoolService;


public class ClassDao extends HibernateDaoSupport{
	
	/**
	 * 所有信息的个数
	 * @return
	 */
	public int findAllCount() {
		// TODO Auto-generated method stub
		String hpl ="select  count(*) from Class";
		List <Long> list = this.getHibernateTemplate().find(hpl);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 根据页面数来查询数据
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<com.example.ssh.Pojo.Class> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria =DetachedCriteria.forClass(com.example.ssh.Pojo.Class.class);
		List<com.example.ssh.Pojo.Class> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		for (int i = 0; i < list.size(); i++) {
			
			int s_id= list.get(i).getSchool().getS_id();
			
			School school =findById_School(s_id);
			list.get(i).setSchool(school);
			
		}
		return list;
		// TODO Auto-generated method stub
		
	}
	public School findById_School(Integer s_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(School.class, s_id);
	}
	/**
	 * 搜索的查询总数
	 * @param s_search
	 * @return
	 */
	public int findSearchCount(String s_search) {
		// TODO Auto-generated method stub
		String hpl ="select  count(*) from Class where c_name like '%"+s_search+"%' or c_info like '%"+s_search+"%' ";
		List <Long> list = this.getHibernateTemplate().find(hpl);
		if(list.size()>0){
			System.out.println("/*********"+list.get(0).intValue()+"********/");
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 搜索的查询
	 * @param s_search
	 * @return
	 */
	public List<com.example.ssh.Pojo.Class> findByPageSreach(int begin, int pageSize, String s_search) {
		// TODO Auto-generated method stub
		Session session = null;
        // 获取被Spring托管的session
        session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hqlString = "FROM  Class  WHERE c_name LIKE '%"+s_search+"%' OR c_info LIKE '%"+s_search+"%'";
		List<com.example.ssh.Pojo.Class> list = new  ArrayList<com.example.ssh.Pojo.Class>();
		Query query = session.createQuery(hqlString.toString());
		query.setMaxResults(pageSize);
		query.setFirstResult(begin); 
		list = query.list();
		
		for (int i = 0; i < list.size(); i++) {
		
			int s_id= list.get(i).getSchool().getS_id();
		
			School school =findById_School(s_id);
			list.get(i).setSchool(school);
		}
		
		return list;
	}
	
	public void add(com.example.ssh.Pojo.Class class1) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(class1);
	}
	
	public com.example.ssh.Pojo.Class finById(Integer c_id) {
		// TODO Auto-generated method stub
		com.example.ssh.Pojo.Class class1 = this.getHibernateTemplate().get(com.example.ssh.Pojo.Class.class, c_id);
		School school = findById_School(class1.getSchool().getS_id());
		class1.setSchool(school);
		return class1;
	}
	
	public void updata(com.example.ssh.Pojo.Class class1) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(class1);
	}
	public List<School> getSchoolList() {
		Session session = null;
        // 获取被Spring托管的session
        session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hqlString = "FROM  School ";
		List<School> list = new  ArrayList<School>();
		Query query = session.createQuery(hqlString.toString()); 
		list = query.list();
		System.out.println("--------->"+list.size());
		session.close();
		// TODO Auto-generated method stub
		return list;
	}

}

