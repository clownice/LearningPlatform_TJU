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
			
		<link rel="stylesheet" href="https://s1.jikexueyuan.com/common/pkg/common_sync0_libs_4d81287.css" /><link rel="stylesheet" href="https://s1.jikexueyuan.com/common/pkg/common_sync1_libs_769abc5.css" /><link rel="stylesheet" href="https://s1.jikexueyuan.com/common/widget/header/header_d41d8cd.css" /><link rel="stylesheet" href="https://s1.jikexueyuan.com/index/pkg/index_sync0_libs_63f8fb8.css" />
		
		<link type="text/css" rel="stylesheet" href="css/global/global.css" />
		<link type="text/css" rel="stylesheet" href="css/main/loginglobal.css" />
		<link type="text/css" rel="stylesheet" href="css/main/login.css" />
		

		
		<script type="text/javascript" src="js/baidutongji.js"></script>
		<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
		<script src="js/login.js" type="text/javascript"></script>
		<title>思政课学习平台</title>
 


	</head>
	
	<script type="text/javascript">
		$(document).ready(function() {
			//试卷菜单下拉层显示
			$("#xuexixingshi").mouseover(function() {
				 $(".xuexixingshibox").show();
			}).mouseout(function() { 
					$(".xuexixingshibox").hide();
			});
			$(".xuexixingshibox").mouseover(function() { 
				$(this).show(); 
			}).mouseout(function() { 
				$(this).hide();
			});
			
			//视频库菜单下拉层显示
			$("#shipin").mouseover(function() {
				 $(".shipinbox").show();
			}).mouseout(function() { 
					$(".shipinbox").hide();
			});
			$(".shipinbox").mouseover(function() { 
				$(this).show(); 
			}).mouseout(function() { 
				$(this).hide();
			});
			
			
			//习题库下拉层显示
			$("#xitiku").mouseover(function() {
				 $(".xitikubox").show();
			}).mouseout(function() { 
					$(".xitikubox").hide();
			});
			$(".xitikubox").mouseover(function() { 
				$(this).show(); 
			}).mouseout(function() { 
				$(this).hide();
			});
		});
	</script>
	
	<body>
	

    <div class="clear"></div>
    <div class="l_main showgrid" >
    	<% out.print("练习题显示页面");
    	
    	%>
    	<div class="clear"></div>
	    <div id="mainnav">
	    	<div class="indexnav showgrid">
	            <ul class="indexnavs">
	                <li><a href="http://localhost:8080/LearningPlatform/MainPageJiandan.jsp"    >首页</a></li>
	                <li><a id="xuexixingshi" href="http://localhost:8080/LearningPlatform/NotReady.jsp" >学习形式</a></li>
	                <li><a id ="shipin" href="http://localhost:8080/LearningPlatform/NotReady.jsp"  >视频题库</a></li>
	                <li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp"  >知识点实例</a></li>
	                <li><a id="xitiku" href="http://localhost:8080/LearningPlatform/NotReady.jsp"  >习题库</a></li>
	                <li><a id="taolunqu" href="http://localhost:8080/LearningPlatform/NotReady.jsp"  >班级讨论区</a></li>
	             
	            </ul>
	            <div class="xuexixingshibox" style="display: none;">
	            	
	                <ul>
	                	<li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp">条目式学习</a></li>
	                    <li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp">关系图学习</a></li>
	                    <li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp" style="border-bottom:none;">全图学习</a></li>
	                </ul>
	            </div>
	            
	            <div class="shipinbox" style="display: none;">
	            	
	                <ul>
	                	<li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp">章节视频库</a></li>
	                    <li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp" style="border-bottom:none;">知识点视频库</a></li>
	                </ul>
	            </div>
	            
	            <div class="xitikubox" style="display: none;">	
	                <ul>
	                	<li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp">章节习题</a></li>
	                    <li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp">知识点习题</a></li>
	                    <li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp">教师安排习题</a></li>
	                    <li><a href="http://localhost:8080/LearningPlatform/NotReady.jsp" style="border-bottom:none;">习题统计</a></li>
	                </ul>
	            </div>
	          
	        </div>
	    </div>
    	
		hahh
		<s:action name="browsePagedExercise" executeResult="True"  namespace="/">
			<s:param name="page">1</s:param>
			<s:param name="numbercount">1</s:param>
		</s:action>
		ooooo
		
		
		
   
	</div>
	</body>     
</html>