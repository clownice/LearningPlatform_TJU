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
			
		<link rel="stylesheet" href="//css.ykimg.com/youku/dist/css/g_6.css" /><link rel="stylesheet" href="//css.ykimg.com/youku/dist/css/find/g_76.css" /><link rel="stylesheet" href="//css.ykimg.com/youku/dist/css/find/play/play_64.css" /><link rel="stylesheet" href="//css.ykimg.com/youku/dist/css/find/play/comment_27.css" />
	
		<link type="text/css" rel="stylesheet" href="css/global/global.css" />
		<link type="text/css" rel="stylesheet" href="css/main/loginglobal.css" />
		<link type="text/css" rel="stylesheet" href="css/main/login.css" />
		
		
		
			<script type="text/javascript" src="ckplayer/ckplayer.js"></script>
	<script type="text/javascript" src="ckplayer/barrage.js"></script>
		
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
    	
		<font size="100">思政课学习平台（logo）</font> 
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
	           
	          
	    </div><!-- 导航 -->
    	
	    <div class="bread_line">
				<p>当前位置：<a href="http://localhost:8080/LearningPlatform/MainPageJiandan.jsp">首页</a><em>></em><a href="http://localhost:8080/LearningPlatform/VideoPlay.jsp" class="on" >视频</a></p>
		</div>
		<!-- 主内容 -->		
		
		
		<div class="base" id="module_basic_title" >
			<div class="base_info">
				
				<span class="stat" id="videoTotalPV" data-stat-role="ck">
				
				</span>
				
				<h1 class="title">
				<%
					String subject = request.getParameter("subject");
					subject = new String(subject.getBytes("iso-8859-1"),"UTF-8");
					String chapter = request.getParameter("chapter");
					chapter = new String(chapter.getBytes("iso-8859-1"),"UTF-8");
					String vname = request.getParameter("vname");
					vname = new String(vname.getBytes("iso-8859-1"),"UTF-8");
				 %>
				<a href="//zy.youku.com/" target="_blank">[<%=subject%>]</a>
				<span><%=chapter %></span>：<span id="subtitle" title="<%=chapter %>"><%=vname %> </span></h1>
				
				
			</div>
		</div>
		
			<s:property value="#videos.vaddress"/>			
				
		 			
	   	<div id= "a1"></div>
		<script type="text/javascript">
		
			function getQueryString(name) {  
		        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");  
		        var r = window.location.search.substr(1).match(reg);  
		        if (r != null) return unescape(r[2]);  
		        return null;  
		   	}  
			var preload=getQueryString("preload");
			var url= getQueryString("url");
			
			
			var flashvars={
				p:0,
				e:1,
				i:'http://localhost:8080/LearningPlatform/'+preload,
				};
			var video=['http://localhost:8080/LearningPlatform/'+url+'->video/mp4'];
			var support=['all'];
			CKobject.embedHTML5('a1','ckplayer_a1',1003,600,video,flashvars,support);
		</script>
		
		
		
		
			
	
	</div>
		
	
	
			
		
		
		
	</body>     
</html>