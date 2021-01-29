package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ClazzAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Clazz_Name ;
    private String Clazz_Introduction ;

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
		
		//查询名称是否存在
		List<ClazzBean> list=new ClazzDao().GetList("Clazz_Name='"+Clazz_Name+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('名称已经存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
		ClazzBean cnbean=new ClazzBean();
		cnbean.setClazz_Name(Clazz_Name);
		cnbean.setClazz_Introduction(Clazz_Introduction);
		new ClazzDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='ClazzManager.action';</script>");
		out.flush();out.close();return null;
		
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
