<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>"> 
  <title>鲜花管理系统</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">

function mycheck(){

   if(isNull(form1.Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(form1.Password.value)){
   alert("请输入密码！");
   return false;
   }
   if(form1.Password.value!=form1.rePassword.value){
	   alert("两次密码不一致！");
	   return false;
	}
      
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>
<center>
  <br><br><br><br><br>
  <table width="684" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="292" align="center" valign="top" background="Images/LoginBg.jpg">
      <table width="350" height="201" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="72" align="center"><h3>鲜花管理系统</h3></td>
        </tr>
        <tr>
          <td align="center" valign="top">
             <form name="form1" action="GoReg.action" method="post" onSubmit="return mycheck()">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="30" colspan="2" align="center" class="STYLE2"><span style="color:red;">
                    <%if(request.getAttribute("Msg")!=null){%>
                    <%=request.getAttribute("Msg")%>
                    <%}%>
                  </span></td>
                  </tr>

                  <td width="37%" height="30" align="right" class="STYLE2">用户名：</td>
                  <td width="300" align="left"><input type="text" name="Username" id="Username" class="text1" /></td>
                  </tr>
                <tr>
                  <td height="30" align="right" class="STYLE2">密码：</td>
                  <td align="left"><input type="password" name="Password" id="Password" class="text1" /></td>
                  </tr>
                <tr>
                <tr>
                  <td height="30" align="right" class="STYLE2">重复密码：</td>
                  <td align="left"><input type="password" name="rePassword" id="rePassword" class="text1" /></td>
                  </tr>
                <tr>
                <tr>
                  <td height="30" align="right" class="STYLE2">姓名：</td>
                  <td align="left"><input type="text" name="Name" id="Name" class="text1" /></td>
                  </tr>
                <tr>
                  <td height="30" colspan="2" align="center"><label>
                    <input type="submit" name="button" id="button" value="注册">
                  </label></td>
                  </tr>
              </table>
              </form>
          
          </td>
        </tr>
      </table></td>
    </tr>
  </table>


</center>
</body>
</html>
