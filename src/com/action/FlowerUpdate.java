package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class FlowerUpdate extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Flower_ID;
	private FlowerBean cnbean;
	public String getFlower_ID() {
		return Flower_ID;
	}

	public void setFlower_ID(String studentID) {
		Flower_ID = studentID;
	}

	public FlowerBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(FlowerBean cnbean) {
		this.cnbean = cnbean;
	}

	private List<ClazzBean> list;
	public List<ClazzBean> getList() {
		return list;
	}
	public void setList(List<ClazzBean> list) {
		this.list = list;
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
		
		//��ѯ���з���
		list=new ClazzDao().GetList("","Clazz_Name");
		//��ѯ
		cnbean=new FlowerDao().GetBean(Integer.parseInt(Flower_ID));
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
