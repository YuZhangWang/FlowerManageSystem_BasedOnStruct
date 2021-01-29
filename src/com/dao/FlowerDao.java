package com.dao;

import com.db.DBHelper;
import com.bean.FlowerBean;

import java.util.*;
import java.sql.*;

public class FlowerDao {
	
	//��ȡ�б�
	public List<FlowerBean> GetList(String strwhere,String strorder){
		String sql="select * from flower,classification where Flower_ClazzID=Clazz_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<FlowerBean> list=new ArrayList<FlowerBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				FlowerBean cnbean=new FlowerBean();
				cnbean.setFlower_ID(rs.getInt("Flower_ID"));
				cnbean.setFlower_ClazzID(rs.getInt("Flower_ClazzID"));
				cnbean.setFlower_Name(rs.getString("Flower_Name"));
				cnbean.setFlower_Type(rs.getString("Flower_Type"));
				cnbean.setFlower_Number(rs.getString("Flower_Number"));
				cnbean.setFlower_Money(rs.getString("Flower_Money"));
				cnbean.setFlower_Sell_Money(rs.getString("Flower_Sell_Money"));
				
				cnbean.setFlower_Pic1(rs.getString("Flower_Pic1"));
				cnbean.setFlower_Pic2(rs.getString("Flower_Pic2"));
				cnbean.setFlower_Pic3(rs.getString("Flower_Pic3"));
				
				cnbean.setClazz_Name(rs.getString("Clazz_Name"));
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
	
	//��ȡָ��ID��ʵ��Bean
	public FlowerBean GetBean(int id){
		String sql="select * from flower,classification where Flower_ClazzID=Clazz_ID and Flower_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		FlowerBean cnbean=new FlowerBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setFlower_ID(rs.getInt("Flower_ID"));
				cnbean.setFlower_ClazzID(rs.getInt("Flower_ClazzID"));
				cnbean.setFlower_Name(rs.getString("Flower_Name"));
				cnbean.setFlower_Type(rs.getString("Flower_Type"));
				cnbean.setFlower_Number(rs.getString("Flower_Number"));
				cnbean.setFlower_Money(rs.getString("Flower_Money"));
				cnbean.setFlower_Sell_Money(rs.getString("Flower_Sell_Money"));
				cnbean.setClazz_Name(rs.getString("Clazz_Name"));
				
				cnbean.setFlower_Pic1(rs.getString("Flower_Pic1"));
				cnbean.setFlower_Pic2(rs.getString("Flower_Pic2"));
				cnbean.setFlower_Pic3(rs.getString("Flower_Pic3"));
				
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
	

	
	//���
	public void Add(FlowerBean cnbean){
		String sql="insert into flower (";
		sql+="Flower_ClazzID,Flower_Name,Flower_Type,Flower_Number,Flower_Money,Flower_Sell_Money,Flower_Pic1,Flower_Pic2,Flower_Pic3";
		sql+=") values(";
		sql+="'"+cnbean.getFlower_ClazzID()+"','"+cnbean.getFlower_Name()+"','"+cnbean.getFlower_Type()+"','"+cnbean.getFlower_Number()+"',"
				+ "'"+cnbean.getFlower_Money()+"','"+cnbean.getFlower_Sell_Money()+"','"+cnbean.getFlower_Pic1()+"','"+cnbean.getFlower_Pic2()+"','"+cnbean.getFlower_Pic3()+"'";
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
	

	
	//�޸�
	public void Update(FlowerBean cnbean){
		String sql="update flower set ";
		sql+="Flower_ClazzID='"+cnbean.getFlower_ClazzID()+"',";
		sql+="Flower_Name='"+cnbean.getFlower_Name()+"',";
		sql+="Flower_Type='"+cnbean.getFlower_Type()+"',";
		sql+="Flower_Number='"+cnbean.getFlower_Number()+"',";
		sql+="Flower_Money='"+cnbean.getFlower_Money()+"',";
		sql+="Flower_Pic1='"+cnbean.getFlower_Pic1()+"',";
		sql+="Flower_Pic2='"+cnbean.getFlower_Pic2()+"',";
		sql+="Flower_Pic3='"+cnbean.getFlower_Pic3()+"',";
		sql+="Flower_Sell_Money='"+cnbean.getFlower_Sell_Money()+"'";
		
		sql+=" where Flower_ID='"+cnbean.getFlower_ID()+"'";
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
	//ɾ��
	public void Delete(String strwhere){
		String sql="delete from flower where ";
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

	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

