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
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Flower_ClazzID.value)){  
   alert("请选择分类！"); 
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改鲜花</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="FlowerUpdateSave.action" onSubmit="return mycheck()" enctype="multipart/form-data">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Flower_ID" type="text" class="noshow" id="Flower_ID" value="<s:property value='cnbean.Flower_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>鲜花分类：</td>
                    <td><select name="Flower_ClazzID" id="Flower_ClazzID">
                      <option value="">请选择</option>
                      <s:iterator id="aa" value="list">
                        <option value="${Clazz_ID}" <s:if test="cnbean.Flower_ClazzID==Clazz_ID">selected</s:if>>${Clazz_Name}</option>
                      </s:iterator>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>鲜花名称：</td>
                    <td><input name="Flower_Name" type="text" class="text2" id="Flower_Name" value="<s:property value='cnbean.Flower_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>花语：</td>
                    <td><input name="Flower_Type" type="text" class="text2" id="Flower_Type" value="<s:property value='cnbean.Flower_Type'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>库存：</td>
                    <td><input name="Flower_Number" type="text" class="text2" id="Flower_Number" value="<s:property value='cnbean.Flower_Number'/>"></td>
                  </tr>
                        <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>原价：</td>
                    <td><input name="Flower_Money" type="text" class="text2" id="Flower_Money" value="<s:property value='cnbean.Flower_Money'/>">></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>销售价格：</td>
                    <td><input name="Flower_Sell_Money" type="text" class="text2" id="Flower_Sell_Money" value="<s:property value='cnbean.Flower_Sell_Money'/>">></td>
                  </tr>
                  
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>文件上传：</td>
                    <td><br/>
						  文件名：<input type="file" name="file" /> <a href="file/<s:property value='cnbean.Flower_Pic1'/>"><s:property value='cnbean.Flower_Pic1'/></a>
						  <input name="Flower_Pic1" type="hidden" class="text2" id="Flower_Pic1" value="<s:property value='cnbean.Flower_Pic1'/>"><br/>
						  文件名：<input type="file" name="file" /><a href="file/<s:property value='cnbean.Flower_Pic2'/>"><s:property value='cnbean.Flower_Pic2'/></a>
						  <input name="Flower_Pic2" type="hidden" class="text2" id="Flower_Pic2" value="<s:property value='cnbean.Flower_Pic2'/>"><br/>
						  文件名：<input type="file" name="file" /><a href="file/<s:property value='cnbean.Flower_Pic3'/>"><s:property value='cnbean.Flower_Pic3'/></a>
						  <input name="Flower_Pic3" type="hidden" class="text2" id="Flower_Pic3" value="<s:property value='cnbean.Flower_Pic3'/>"><br/>
                    </td>
                  </tr>
                  
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改鲜花">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
