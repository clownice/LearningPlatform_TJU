<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%@ page language="java" import="edu.etju.model.Student"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<meta name="description"
			content=""/>
		<link type="text/css" rel="stylesheet" href="css/global/global.css" />
		<link type="text/css" rel="stylesheet" href="css/main/loginglobal.css" />
		<link type="text/css" rel="stylesheet" href="css/main/login.css" />
		<script type="text/javascript" src="js/baidutongji.js"></script>
		<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
		<script src="js/login.js" type="text/javascript"></script>
		<title>思政课学习平台</title>


	</head>
	

	
	<body>
	

    <div class="clear"></div>
    <div class="l_main showgrid" >
    	<% Student student = (Student)session.getAttribute("Student");
    		out.print(student.getSaname());	
    	
    	%>
		暂未开放此功能
    
   
	</div>
	</body>     
</html>