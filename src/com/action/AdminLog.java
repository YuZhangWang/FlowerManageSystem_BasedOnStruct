package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class AdminLog extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<ClazzBean> buildinglist;
	private List<FlowerBean> flowerlist;

	public List<ClazzBean> getClazzlist() {
		return buildinglist;
	}

	public void setClazzlist(List<ClazzBean> buildinglist) {
		this.buildinglist = buildinglist;
	}

	public List<FlowerBean> getFlowerlist() {
		return flowerlist;
	}

	public void setFlowerlist(List<FlowerBean> flowerlist) {
		this.flowerlist = flowerlist;
	}

	private String ClazzID;
	private String FlowerID;
	public String getClazzID() {
		return ClazzID;
	}

	public void setClazzID(String buildingID) {
		ClazzID = buildingID;
	}

	public String getFlowerID() {
		return FlowerID;
	}

	public void setFlowerID(String flowerID) {
		FlowerID = flowerID;
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
		
		//��ѯ
		buildinglist=new ClazzDao().GetList("","Clazz_Name");
//		System.out.println(ClazzID);
		//��ѯ����
		String strWhere="1=1 ";
		if(!(isInvalid(ClazzID)))
		{
			strWhere+=" and Flower_ClazzID='"+ClazzID+"'";
		}
		else{
			strWhere+=" and 1=2";
		}
		//��ѯ����
		flowerlist=new FlowerDao().GetList(strWhere,"Flower_Name");
		
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
