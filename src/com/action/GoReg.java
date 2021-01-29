package com.action;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.dao.*;
import com.bean.*;

import com.opensymphony.xwork2.ActionSupport;

public class GoReg extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Type;
	private String Username;
	private String Password;
	private String Name;

	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	//�����û������execute����
	public String execute() throws Exception {
		
		AdminBean cnbean = new AdminBean();
		cnbean.setAdmin_err(0);
		cnbean.setAdmin_Name(Name);
		cnbean.setAdmin_Password(Password);
		cnbean.setAdmin_State("0");
		cnbean.setAdmin_Username(Username);
		
		new AdminDao().Add(cnbean);

		return SUCCESS;
		
		
	}
}
