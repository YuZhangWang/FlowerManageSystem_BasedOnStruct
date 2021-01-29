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

	//下面是Action内用于封装用户请求参数的属性
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
	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//查询所有分类
		list=new ClazzDao().GetList("","Clazz_Name");
		//查询
		cnbean=new FlowerDao().GetBean(Integer.parseInt(Flower_ID));
		return SUCCESS;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
