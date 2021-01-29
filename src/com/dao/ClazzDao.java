package com.dao;

import com.db.DBHelper;
import com.bean.ClazzBean;

import java.util.*;
import java.sql.*;

public class ClazzDao {
	
	//获取列表
	public List<ClazzBean> GetList(String strwhere,String strorder){
		String sql="select * from classification";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ClazzBean> list=new ArrayList<ClazzBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ClazzBean cnbean=new ClazzBean();
				cnbean.setClazz_ID(rs.getInt("Clazz_ID"));
				cnbean.setClazz_Name(rs.getString("Clazz_Name"));
				cnbean.setClazz_Introduction(rs.getString("Clazz_Introduction"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//获取指定ID的实体Bean
	public ClazzBean GetBean(int id){
		String sql="select * from classification where Clazz_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ClazzBean cnbean=new ClazzBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setClazz_ID(rs.getInt("Clazz_ID"));
				cnbean.setClazz_Name(rs.getString("Clazz_Name"));
				cnbean.setClazz_Introduction(rs.getString("Clazz_Introduction"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//添加
	public void Add(ClazzBean cnbean){
		String sql="insert into classification (";
		sql+="Clazz_Name,Clazz_Introduction";
		sql+=") values(";
		sql+="'"+cnbean.getClazz_Name()+"','"+cnbean.getClazz_Introduction()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//修改
	public void Update(ClazzBean cnbean){
		String sql="update classification set ";
		sql+="Clazz_Name='"+cnbean.getClazz_Name()+"',";
		sql+="Clazz_Introduction='"+cnbean.getClazz_Introduction()+"'";
		
		sql+=" where Clazz_ID='"+cnbean.getClazz_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete from classification where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

