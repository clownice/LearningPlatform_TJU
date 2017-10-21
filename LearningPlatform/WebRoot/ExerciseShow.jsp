<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%@ page language="java" import="edu.etju.model.Esrepertory"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="https://s1.jikexueyuan.com/common/pkg/common_sync0_libs_4d81287.css" /><link rel="stylesheet" href="https://s1.jikexueyuan.com/common/pkg/common_sync1_libs_769abc5.css" /><link rel="stylesheet" href="https://s1.jikexueyuan.com/common/widget/header/header_d41d8cd.css" /><link rel="stylesheet" href="https://s1.jikexueyuan.com/index/pkg/index_sync0_libs_63f8fb8.css" />
	
  </head>
  
  <body>
  		exerciseshow
  		<%
    		List list = (List)request.getAttribute("exercises");
    		int len = list.size();
    		String[][] option = new String[len][4];
    		Esrepertory es = new Esrepertory();
    		int i = 0;
    		Iterator iterator= list.iterator();
    		while(iterator.hasNext())
    		{
	    		 es= (Esrepertory)iterator.next();
	    		String optioncontext = es.getOptioncontext();
	    		option[i]=optioncontext.split(" ");
	    		i++;
    		
    		}
    		
    		
    		 %>
    	<s:iterator value="#request.exercises" id="exercises">
    		<a href="" target="_self"><s:property value="#exercises.title"/></a>
    		
    		
	    		
    	
    	</s:iterator>
    	
    	 <div class="shiti">
		<p><s:property value="#exercises.title"/>（2分）
			<table name="optionsTable" cellpadding="0" cellspacing="0" width="100%">
				<tr><td width="100%">A．<%=option[0][0] %><b  alt='21题库'  class="hidejammersa" ></b>&nbsp;</td></tr>
				<tr><td width="100%">B．<%=option[0][1]%><b  alt='21题库'  class="hidejammersa" ></b>&nbsp;</td></tr>
				<tr><td width="100%">C．<%=option[0][2]%><b  alt='21题库'  class="hidejammersa" ></b>&nbsp;</td></tr>
				<tr><td width="100%">D．<%=option[0][3] %><b  alt='21题库'  class="hidejammersa" ></b>&nbsp;</td></tr>
			</table>
		</p>
		<p class="btns"></p>
		<a href='' target=_blank class="paper_viewall">答案与解析</a>
		<a class="paper_viewall to-zujuan" href="" target="_blank" alt="在线组卷">在线组卷</a>
		                        
		<div id='an_0' style="display: none;"> <b>答案：</b>-<br/><b>解析：</b>-</div>
    	</div>
    	
  </body>
</html>
