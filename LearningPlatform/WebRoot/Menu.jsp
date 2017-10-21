<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%@ page language="java" import="edu.etju.model.Student"%>
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
  		<!--  
    	<s:iterator value="#request.videos" id="videos">
    		<a href="<s:property value="#videos.vaddress"/>" target="_self"><s:property value="#videos.vaddress"/></a>
    		
    		
	    		
    	
    	</s:iterator>
    	-->
    	Menu.jsp
    	<div class="jk-uptodate">
			    <h2>视频课程</h2>
			   
    				
    				
		    		<ul>
					     <s:iterator value="#request.videos" id="videos">
					        <li class="uptodate">
					            <a href="VideoPlay.jsp?preload=<s:property value="#videos.context"/>&url=<s:property value="#videos.vaddress"/>&subject=<s:property value="#videos.subject"/>&vname=<s:property value="#videos.vname"/>&chapter=<s:property value="#videos.chapter"/>" target="_blank">
					                <img class="uptodate-img" src="<s:property value="#videos.context"/>" width="100%" height="100%" alt=""></img>
					                <p class="uptodate-title"><s:property value="#videos.vname"/></p>
					                
					                <p class="uptodate-info">
					                    <s:property value="#videos.subject"/>
					                    <span>|</span><s:property value="#videos.chapter"/>
					                    
					                </p>
					            </a>
					        </li>
					        
					      </s:iterator>
					    </ul>
	    		
    	
    			
			    
			</div>
    	
  </body>
</html>
