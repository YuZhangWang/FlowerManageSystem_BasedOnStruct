package com.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class FlowerAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Flower_ClazzID ;
    private String Flower_Name ;
    private String Flower_Type ;
    private String Flower_Number ;
    

    private String Flower_Money ;
    private String Flower_Sell_Money ;
    
    
    private File[] file;
    private String[] fileContentType;
    private String[] fileFileName;

    public File[] getFile() {
        return file;
    }
    public void setFile(File[] file) {
        this.file = file;
    }
    public String[] getFileContentType() {
        return fileContentType;
    }
    public void setFileContentType(String[] fileContentType) {
        this.fileContentType = fileContentType;
    }
    public String[] getFileFileName() {
        return fileFileName;
    }
    public void setFileFileName(String[] fileFileName) {
        this.fileFileName = fileFileName;
    }



	public String getFlower_ClazzID() {
		return Flower_ClazzID;
	}

	public void setFlower_ClazzID(String flowerClazzID) {
		Flower_ClazzID = flowerClazzID;
	}

	public String getFlower_Name() {
		return Flower_Name;
	}

	public void setFlower_Name(String flowerName) {
		Flower_Name = flowerName;
	}

	public String getFlower_Type() {
		return Flower_Type;
	}

	public void setFlower_Type(String flowerType) {
		Flower_Type = flowerType;
	}

	public String getFlower_Number() {
		return Flower_Number;
	}

	public void setFlower_Number(String flowerNumber) {
		Flower_Number = flowerNumber;
	}




	public String getFlower_Money() {
		return Flower_Money;
	}

	public void setFlower_Money(String flower_Money) {
		Flower_Money = flower_Money;
	}

	public String getFlower_Sell_Money() {
		return Flower_Sell_Money;
	}

	public void setFlower_Sell_Money(String flower_Sell_Money) {
		Flower_Sell_Money = flower_Sell_Money;
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
		
		//查询是否存在
		List<FlowerBean> list=new FlowerDao().GetList("Flower_Name='"+Flower_Name+"' and Flower_ClazzID="+Flower_ClazzID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该分类中已经存在该花！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
		FlowerBean cnbean=new FlowerBean();
		cnbean.setFlower_ClazzID(Integer.parseInt(Flower_ClazzID));
		cnbean.setFlower_Name(Flower_Name);
		cnbean.setFlower_Type(Flower_Type);
		cnbean.setFlower_Number(Flower_Number);
		cnbean.setFlower_Money(Flower_Money);
		cnbean.setFlower_Sell_Money(Flower_Sell_Money);
		
		String pic1="";
		String pic2="";
		String pic3="";
		
		 if(file!=null&&file.length>0){
	            File destFile = null;
	            try{
	                for(int i=0;i<file.length;i++){

	                        File f =file[i];
	                        destFile =  new File(ServletActionContext.getRequest().getRealPath("/file"),fileFileName[i]);
	                        FileUtils.copyFile(f, destFile);
	                        if(i==0) {
	                        	pic1=fileFileName[0];
	              
	                        }
	                        if(i==1) {
	                        	pic2=fileFileName[1];
	                        }
	                        if(i==2) {
	                        	pic3=fileFileName[2];
	                        }
	                }
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	        }   
	    cnbean.setFlower_Pic1(pic1);
	    cnbean.setFlower_Pic2(pic2);
	    cnbean.setFlower_Pic3(pic3);
		 
		new FlowerDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='FlowerManager.action';</script>");
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
