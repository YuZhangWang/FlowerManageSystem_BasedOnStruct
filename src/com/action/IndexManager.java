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

	//下面是Action内用于封装用户请求参数的属性
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
		//查询条件
		String strWhere="1=1";
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}
		if(!(isInvalid(Flower_ClazzID)))
		{
			strWhere+=" and Flower_ClazzID='"+Flower_ClazzID+"'";
		}
		
		//查询所有
		buildinglist=new ClazzDao().GetList("","Clazz_Name");
		
		//查询
		list=new FlowerDao().GetList(strWhere,"Flower_Name");
		for(FlowerBean f:list) {
			String pic= f.getFlower_Pic1();
			pic+= ","+f.getFlower_Pic2();
			pic+= ","+f.getFlower_Pic3();
			f.setFlower_Pic(pic);
		}
		
	
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
