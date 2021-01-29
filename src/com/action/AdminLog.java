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

	//下面是Action内用于封装用户请求参数的属性
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
		
		//查询
		buildinglist=new ClazzDao().GetList("","Clazz_Name");
//		System.out.println(ClazzID);
		//查询条件
		String strWhere="1=1 ";
		if(!(isInvalid(ClazzID)))
		{
			strWhere+=" and Flower_ClazzID='"+ClazzID+"'";
		}
		else{
			strWhere+=" and 1=2";
		}
		//查询寝室
		flowerlist=new FlowerDao().GetList(strWhere,"Flower_Name");
		
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
