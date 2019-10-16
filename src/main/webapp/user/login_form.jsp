<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>--%>

	</head>

	<body>


		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form method="post" action="${pageContext.request.contextPath}/user/login" id="ctl00">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input onblur="email1()" type="text" name="userEmail" id="txtUsername" class="textbox" />

								</li><span id="email"></span>
								<li>
									<span class="blank">密码：</span>
									<input onblur="email2()" type="password" name="password" id="txtPassword"
										class="textbox" />
								</li><span id="email2"></span>
								<li>
									<span class="blank">验证码：</span>
									<input onblur="email3()" type="text" name="code" 	class="textbox" />
									<img id="tupian" class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/validationcodeaction.png" />
									<a onclick="f()" href="#" >看不清楚？换个图片</a>
								</li><span id="email3"></span><br/><br/>
								<li>
									<input onclick="return f1()" type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
	<script type="text/javascript">
		function f() {
			var tu = document.querySelector("#tupian");
			tu.src="${pageContext.request.contextPath}/validationcodeaction.png?r="+Math.random();
		}
		function email1() {
			var email = document.querySelector("#email");
			var e = document.querySelector("#txtUsername");
			var aite = e.value.indexOf("@");
			var dian = e.value.indexOf(".");
			if(e.value.trim()==""){
				email.innerHTML="输入为空，请输入邮箱";
				return false;
			}else if(!((dian - aite) >= 2) ){
				email.innerHTML="输入的邮箱不合法，请重新输入";
				return false;
			}else {
				email.innerHTML="";
			}

			return true;

		}
		function email2() {
			var email = document.querySelector("#email2");
			var e = document.querySelector("#txtPassword");
			if(e.value.trim()==""){
				email.innerHTML="输入为空，请输入密码";
				return false;
			}else {
				email.innerHTML="";
			}
			return true;
		}
		function email3() {
			var email = document.querySelector("#email3");
			var e = document.querySelector("input[name=code]");
			if(e.value.trim()==""){
				email.innerHTML="输入为空，请输入验证码";
				return false;
			}else {
				email.innerHTML="";
			}
			return true;
		}
		function f1() {
			var e1 = email1();
			var e2 = email2();
			var e3 = email3();
			<!--return e1&&e2&&e3;-->
			return !(!e1 || !e2 || !e3);
		}

	</script>
</html>