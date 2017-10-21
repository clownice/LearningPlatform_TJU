		$(function(){
			$('#imgcheck').bind('keydown',function(event){
	       		if(event.keyCode == 13){
	       			logincheck();
	       		};
	        });
			$('#autologin').bind('keydown',function(event){
	       		if(event.keyCode == 13){
	       			logincheck();
	       		};
	        });
			if(!placeholderSupport()){   // 判断浏览器是否支持 placeholder
			    $('[placeholder]').focus(function() {
			        var input = $(this);
			        if (input.val() == input.attr('placeholder')) {
			            input.val('');
			            input.removeClass('placeholder');
			        }
			    }).blur(function() {
			        var input = $(this);
			        if (input.val() == '' || input.val() == input.attr('placeholder')) {
			            input.addClass('placeholder');
			            input.val(input.attr('placeholder'));
			        }
			    }).blur();
			};
		});
		
		function placeholderSupport() {
		    return 'placeholder' in document.createElement('input');
		}
		 
		function logincheck(){
			var loginname=jQuery('#loginname').val();
			var password=jQuery('#password').val();
			var imgcheck=jQuery('#imgcheck').val();
			var submitFlag = true;
			if(loginname == "" || loginname == null || loginname == "学号/工号"){
				showErr('loginname',"请输入登录账号");
				//$('#loginname').focus();
				submitFlag = false;
				return;
			}else if(loginname.indexOf(" ")>-1){
				showErr('loginname',"账号中不能含有空格");
				//$('#loginname').focus();
				submitFlag = false;
				return;
			}
			//var password=jQuery('#password').val();
			if(password == ""||password == null||password == "请输入您的密码"){
				showErr('password',"请输入密码");
				//$('#password').focus();
				submitFlag = false;
				return;
			}else if(password.length<6){
				showErr('password',"密码不能少于6位字符");
				//$('#password').focus();
				submitFlag = false;
				return;
			}else if(password.indexOf(" ")>-1){
				showErr('password',"密码中不能含有空格");
				//$('#password').focus();
				submitFlag = false;
				return;
			}
			if(imgcheck == "" || imgcheck == null || imgcheck == "请输入6位图形验证码"){
				showErr('imgcheck',"请输入6位图形验证码");
				//$('#imgcheck').focus();
				submitFlag = false;
				return;
			}else if(imgcheck.length!=6){
				showErr('imgcheck',"图形验证码为6位数字");
				//$('#imgcheck').focus();
				submitFlag = false;
				return;
			}else if(imgcheck.indexOf(" ")>-1){
				showErr('imgcheck',"验证码中不能含有空格");
				//$('#imgcheck').focus();
				submitFlag = false;
				return;
			}
			if(submitFlag){
				$('#loginForm').submit();
				return false;
			}
		}
		function inputblur(inputid){
			if(inputid=='loginname'){
				var loginname=jQuery('#'+inputid).val();
				if(loginname == ""||loginname == null||loginname == "学号/工号"){
					return;
				}else if(loginname.indexOf(" ")>-1){
					showErr(inputid,"账号中不能含有空格");
					return;
				}else{
					showRight(inputid);
				}
			}else if(inputid=='password'){
				var password=jQuery('#password').val();
				if(password == ""||password == null||password == "请输入您的密码"){
					return;
				}else if(password.length<6 && password != "请输入您的密码"){
					showErr(inputid,"密码不能少于6位字符");
					return;
				}else if(password.indexOf(" ")>-1){
					showErr(inputid,"密码中不能含有空格");
					return;
				}else{
					showRight(inputid);
				}
			}else if(inputid=='imgcheck'){
				var imgcheck=jQuery('#imgcheck').val();
				if(imgcheck == ""||imgcheck == null||imgcheck == "请输入6位图形验证码"){
					return;
				}else if(imgcheck.length!=6){
					showErr(inputid,"图形验证码为6位数字");
					return;
				}else if(imgcheck.indexOf(" ")>-1){
					showErr(inputid,"验证码中不能含有空格");
					return;
				}else{
					showRight(inputid);
				}
			}
		}
		function showErr(inputid,errtxt){
			$('#'+inputid+'_err').html('<em></em>'+errtxt);
			$('#'+inputid+'_right').hide();
		}
		function showRight(inputid){
			$('#'+inputid+'_right').show();
			$('#'+inputid+'_err').html('');
		}
		
		