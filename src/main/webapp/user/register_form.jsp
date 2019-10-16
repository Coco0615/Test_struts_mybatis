
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
		<script type="text/javascript">

			function fEmail() {
				var e = document.querySelector("#txtEmail")
				var email = document.querySelector("#pEmail");
				var aite = e.value.indexOf("@");
				var dian = e.value.indexOf(".");
				if(e.value.trim()==""){
					email.innerHTML="输入为空，请输入邮箱。";
					return false;
				}else if(!((dian - aite) >= 2) ){
					email.innerHTML="输入的邮箱不合法，请重新输入。";
					return false;
				}else {
					$.ajax({
						url:"${pageContext.request.contextPath}/user/ajax",
						type:"post",
						data:"email="+$("#txtEmail").val(),
						success:function (e) {
							email.innerHTML=""+e;
							if(e=="用户名已存在！"){
								console.log(22222222);
								return false;

							}else {
								console.log(11111111);
								return true;
							}
						},
						dateType:"text"
					})


				}
				return true;
			}
			function fNickName() {
				var e = document.querySelector("#txtNickName")
				var nickName1 = document.querySelector("#pNickName1");
				var nickName2 = document.querySelector("#pNickName2");
				if(e.value.trim()==""){
					nickName1.innerHTML="昵称为空，请输入昵称。";
					nickName2.innerHTML="";
					return false;
				}else if(!(e.value.length > 4)){
					nickName1.innerHTML="昵称太短，请重新输入昵称。";
					nickName2.innerHTML="";
					return false;
				}else if(e.value.length>20){
					nickName1.innerHTML="昵称过长，请重新输入昵称。";
					nickName2.innerHTML="";
					return false;
				}else {
					nickName1.innerHTML="此昵称可用。";
					nickName2.innerHTML="";

				}
				return true;
			}
			function fPassword1() {
				var e = document.querySelector("#txtPassword")
				var password1 = document.querySelector("#pPassword1");
				if(e.value.trim()==""){
					password1.innerHTML="密码为空，请输入密码。";
					return false;
				}else if(!(e.value.length > 5)){
					password1.innerHTML="密码太短，请重新输入密码。";
					return false;
				}else if(e.value.length>20){
					password1.innerHTML="密码过长，请重新输入密码。";
					return false;
				}else {
					password1.innerHTML="1";

				}
				return true;
			}
			function fPassword2() {
				var e = document.querySelector("#txtRepeatPass")
				var password = document.querySelector("#txtPassword");
				var password2 = document.querySelector("#password1Info");
				if(e.value.trim()==""){
					password2.innerHTML="确认密码为空，请确认密码。";
					return false;
				}else if(e.value.trim()!=password.value.trim()){
					password2.innerHTML="两次密码不一致，请确认密码。";
					return false;
				}else {
					password2.innerHTML="1";

				}
				return true;
			}
			function f() {
				console.log(fEmail());
				console.log(fNickName());
				console.log(fPassword1());
				console.log(fPassword2());
				var email = document.querySelector("#txtEmail").value;

				var nickName = document.querySelector("#txtNickName").value;
				var password = document.querySelector("#txtPassword").value;
				var password1 = document.querySelector("#txtRepeatPass").value;
				if(fEmail()&&fNickName()&&fPassword1()&&fPassword2()){
					return true;
				}else {
					return false;
				}
			}

		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form action="${pageContext.request.contextPath}/user/register" onsubmit="return f()" name="ctl00" method="post"  id="f">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input onblur="fEmail()" name="email" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p id="pEmail">
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="emailInfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input onblur="fNickName()" name="nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p id="pNickName1">
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p id="pNickName2">
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input onblur="fPassword1()" name="password" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p id="pPassword1">
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input onblur="fPassword2()" name="password1" type="password" id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮箱验证码：
						</td>
						<td>
							<input name="send" type="text" id="txtVerifyCode"
								class="yzm_input"/>
							<input id="email" type="button" value="发送邮箱验证码"/>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input  id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
<script>
	$("#email").click(function () {
		if(fEmail()){

		}else {
			alert("请输入邮箱！");
			return;
		}
		$.ajax({
			url:"${pageContext.request.contextPath}/user/yanzhengma",
			data:"email="+$("#txtEmail").val(),
			type:"post",
			success:function () {
				alert("1111");
			}
		})
		$("#email").prop("disabled",true);
		var i=10;
		var j=window.setInterval(function () {
			$("#email").prop("value",i+"秒后重新发送");
			i--;
			if(i==-1){
				$("#email").prop("disabled",false);
				$("#email").prop("value","发送邮箱验证码");
				window.clearInterval(j);
			}
		},1000);
	})
</script>
</html>

