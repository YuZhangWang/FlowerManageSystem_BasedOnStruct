package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ClazzUpdateSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Clazz_ID ;
    private String Clazz_Name ;
    private String Clazz_Introduction ;
	public String getClazz_ID() {
		return Clazz_ID;
	}

	public void setClazz_ID(String buildingID) {
		Clazz_ID = buildingID;
	}

	public String getClazz_Name() {
		return Clazz_Name;
	}

	public void setClazz_Name(String buildingName) {
		Clazz_Name = buildingName;
	}

	public String getClazz_Introduction() {
		return Clazz_Introduction;
	}

	public void setClazz_Introduction(String buildingIntroduction) {
		Clazz_Introduction = buildingIntroduction;
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
		
		//��ѯ�����Ƿ����
		List<ClazzBean> list=new ClazzDao().GetList("Clazz_Name='"+Clazz_Name+"' and Clazz_ID!="+Clazz_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('�����Ѿ����ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//�޸�
		ClazzBean cnbean=new ClazzBean();
		cnbean=new ClazzDao().GetBean(Integer.parseInt(Clazz_ID));
		cnbean.setClazz_Name(Clazz_Name);
		cnbean.setClazz_Introduction(Clazz_Introduction);
		new ClazzDao().Update(cnbean); 
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='ClazzManager.action';</script>");
		out.flush();out.close();return null;
		
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
