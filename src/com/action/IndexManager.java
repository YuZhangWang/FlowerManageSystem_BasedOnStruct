package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class IndexManager extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<FlowerBean> list;
	public List<FlowerBean> getList() {
		return list;
	}
	public void setList(List<FlowerBean> list) {
		this.list = list;
	}
	private String SearchRow;
	private String SearchKey;
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	private List<ClazzBean> buildinglist;
	public List<ClazzBean> getClazzlist() {
		return buildinglist;
	}
	public void setClazzlist(List<ClazzBean> buildinglist) {
		this.buildinglist = buildinglist;
	}
	private String Flower_ClazzID;
	public String getFlower_ClazzID() {
		return Flower_ClazzID;
	}
	public void setFlower_ClazzID(String domitoryClazzID) {
		Flower_ClazzID = domitoryClazzID;
	}
	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		//��ѯ����
		String strWhere="1=1";
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}
		if(!(isInvalid(Flower_ClazzID)))
		{
			strWhere+=" and Flower_ClazzID='"+Flower_ClazzID+"'";
		}
		
		//��ѯ����
		buildinglist=new ClazzDao().GetList("","Clazz_Name");
		
		//��ѯ
		list=new FlowerDao().GetList(strWhere,"Flower_Name");
		for(FlowerBean f:list) {
			String pic= f.getFlower_Pic1();
			pic+= ","+f.getFlower_Pic2();
			pic+= ","+f.getFlower_Pic3();
			f.setFlower_Pic(pic);
		}
		
	
		return SUCCESS;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}
	
}
