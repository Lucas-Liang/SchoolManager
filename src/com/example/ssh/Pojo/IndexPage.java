package com.example.ssh.Pojo;

import java.util.List;

/**
 * 
*<p>Title: IndexPage</p>
*<p>Description: </p>
*<p>Company: </p> 
*@author * @date
 * @param <T>
 */
public class IndexPage<T> {
	private int indexPage;/*��ǰ��ҳ��*/
	private int pageSize;/*ÿҳ��ʾ����Ŀ*/
	private int pageCount;/*�ܵļ�¼��*/
	private int indexCount;/*ҳ������*/
	private List<T> list;/*����*/
	
	@Override
	public String toString() {
		return "IndexPage [indexPage=" + indexPage + ", pageSize=" + pageSize + ", pageCount=" + pageCount
				+ ", indexCount=" + indexCount + ", list=" + list + "]";
	}
	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getIndexCount() {
		return indexCount;
	}
	public void setIndexCount(int indexCount) {
		this.indexCount = indexCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	

}
