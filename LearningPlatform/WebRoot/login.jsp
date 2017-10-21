<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<script type="text/javascript">
		var t1;//重复登陆提示层，用定时器
		$(function(){
			var from='';
			if(from!=null && from!='' && from.indexOf('payment.htm')>=0){
				$('.tg_charge').show();
			}else if(from!=null && from!='' && (from.indexOf('myBookShelf')>=0 || from.indexOf('tiguBookStore')>=0 || from.indexOf('collectBookInXPList')>=0)){
				$('.loginleft_pic').show();
			}
			var msg='';
			if(msg != null && msg != "" && msg.length>0){
				//alert(msg);
				if(msg.indexOf("账号")>-1){
					showErr("loginname",msg);
				}else if(msg.indexOf("密码")>-1){
					showErr("password",msg);
				}else if(msg.indexOf("验证码")>-1){
					//alert(msg);
					showErr("imgcheck",msg);
				}else if(msg.indexOf("Cookie")>-1){
					showErr("loginname",msg);
				}else{
					alert(msg);
				}
			}
			var reLoginMsg='';
			if(reLoginMsg!=null && reLoginMsg=='relogin'){
				showReLoginDiv();
			}else{
				hideReLoginDiv();
			}
		});
		$.ajaxSetup ({
	    	cache: false //关闭AJAX相应的缓存
		});
		function showJifenDiv(){
			$('.jiucuo_boxbg').show();
			$('.jifenbox').show();
		}
		function hideJifenDiv(){
			$('.jiucuo_boxbg').hide();
			$('.jifenbox').hide();
		}
		function hideReLoginDiv(){
			$('.repeat_loginbox').hide();
			window.clearTimeout(t1);//去掉定时器 
		}
		function showReLoginDiv(){
			$('.repeat_loginbox').show();
			t1 = window.setTimeout(hideReLoginDiv,3000); 
		}
		</script>
	</head>
	<body>
	<div class="bodymin">
	<!--积分规则弹出层-->
    <div class="jiucuo_boxbg"  style="display:none"></div>
    <div class="jifenbox"  style="display:none">
    	<a href="javascript:void(0);hideJifenDiv();"><img src="images/login_new/tg_jifen_closebut.png" /></a>
    </div>
    <!--重复登录提示弹出层-->
   	<div class="repeat_loginbox">
    	<a href="javascript:void(0);hideReLoginDiv();"><img src="images/login_new/tg_jifen_closebut.png" /></a>
        <p>你的账号已经在其他地方登录<br />请重新登录</p>
    </div>
    <div class="top_logo showgrid">
        <a href="http://localhost:8080/LearningPlatform/" class="logo" ><img src="images/bigimages/l_logo.png" /></a>
        <div class="top_l_right">
        	<p>还没有账号？</p>
            <a href="http://localhost:8080/LearningPlatform/register.jsp">注</a>
        </div>
    </div>
    <div class="clear"></div>
    <div class="l_main showgrid" >
    	<div class="tg_charge" style="display:none">
        </div>
        <div class="loginleft_pic"  style="display:none"><img src="images/login_new/login_left_pic.png" /></div>
    	<div class="loginbox">
        	<ul class="dlnav">
            	<li id="mobile_tab" class="dl_zhanghao on"><a ><em></em>账号登录</a></li>
            </ul>
            <!--手机登录-->
            <form action="checkUser" id="loginForm" method="get">
            <div class="clear"></div>
            <div class="mobile_login" >
            	<div class="mobile_number">
                	<div class="m_nunmber_con">
                        <span></span>
                        <input value="" placeholder="学号/工号" type="text"  id="loginname" name="loginname"   maxlength="40"  onblur="javascript:return inputblur('loginname');"/>
						<input type="hidden" name="forward" value="http://localhost:8080/LearningPlatform/index.jsp/"/>
                    </div>
                    <em id="loginname_right" class="right_pic" style="display:none;"></em>
                    <div class="clear"></div>
                	<p id="loginname_err"  class="error_tishi"></p>
                </div>
                <div class="mobile_number">
                	<div class="m_nunmber_con m_password_con">
                        <span></span>
                        <input type="password"  placeholder="请输入您的密码" value="" id="password" name="password" maxlength="12"   onblur="javascript:return inputblur('password');"/>
                    </div>
                    <em id="password_right" class="right_pic" style="display:none;"></em>
                    <div class="clear"></div>
                	<p id="password_err" class="error_tishi"></p>
                </div>
                <div class="mobile_number">
                	<div class="yanzhengma">
                        <input class="yanzhengma_box" type="text" name="imgcheck" id="imgcheck"  maxlength="6" value="" placeholder="请输入6位图形验证码"   onblur="javascript:return inputblur('imgcheck');" />
                        <img src="getValidateCode.do"  onclick="javascript:this.src=this.src+'?rnd=' + Math.random();" title="看不清,点击刷新"/>
                    </div>
                    <em id="imgcheck_right" class="right_pic" style="display:none;"></em>
                    <div class="clear"></div>
                	<p id="imgcheck_err" class="error_tishi"></p>
                </div>
                <div class="zidongdenglu">
                	<p><input type="radio" name="rolecheck" id="xueshengcheck" value="student" checked/>我是学生</p>
                	<p>&nbsp;</p>
                	<p><input type="radio" name="rolecheck" id="laoshicheck" value="teacher" />我是老师</p>
                    <a href="http://localhost:8080/LearningPlatform/foundpwd.htm">找回密码</a>
                </div>
                <a href="javascript:void(0);logincheck();" class="login_button">马上登录</a>
                <div class="clear"></div>
                
            	</div>
            </form>
        </div>
    </div>
    
   
	</div>
	</body>     
</html>