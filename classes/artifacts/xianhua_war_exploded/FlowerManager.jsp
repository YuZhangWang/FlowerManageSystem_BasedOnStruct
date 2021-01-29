<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>鲜花管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">鲜花管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">鲜花管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="FlowerManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="30" style="padding-left:20px;"> 功能导航： <a href="FlowerAdd.action">添加鲜花</a></td>
                    <td width="78%">查询：
                     
                      <select name="SearchRow" id="SearchRow">
                        <option value="Flower_Name">鲜花名</option>
                        <option value="Flower_Type">花语</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>鲜花分类</strong></td>
                    <td bgcolor="#D5E4F4"><strong>鲜花名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>花语</strong></td>
                    <td bgcolor="#D5E4F4"><strong>库存</strong></td>
                    <td bgcolor="#D5E4F4"><strong>原价</strong></td>
                    <td bgcolor="#D5E4F4"><strong>销售价</strong></td>
                    <td bgcolor="#D5E4F4"><strong>图片</strong></td>
                    
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Clazz_Name}</td>
                      <td>${Flower_Name}</td>
                      <td>${Flower_Type}</td>
                      <td align="center">${Flower_Number}</td>
                      
                      
                      <td align="center">${Flower_Money}</td>
                      <td align="center">${Flower_Sell_Money}</td>
                          <td align="center">${Flower_Pic}</td>
                      <td align="center"><a href="FlowerUpdate.action?Flower_ID=${Flower_ID}">修改</a> 
                      <a href="FlowerDel.action?Flower_ID=${Flower_ID}" onClick="return confirm('确定要删除该鲜花吗？')">删除</a></td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
