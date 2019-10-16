<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function checkname() {
			var receiveName = $("#receiveName").prop("value");
			if(receiveName.trim()==""){
				$("#pname").text("收件人为空，请重新输入。");
			}else {
				$("#pname").text("");
			}
		}
		function checkeaddress() {
			var fullAddress = $("#fullAddress").prop("value");
			if(fullAddress.trim()==""){
				$("#paddress").text("地址为空，请重新输入。");
			}else {
				$("#paddress").text("");
			}
		}
		function checkphone() {
			var phone = $("#phone").prop("value");
			if(phone.trim()==""){
				$("#pphone").text("电话为空，请重新输入。");
			}else {
				$("#pphone").text("");
			}
		}


	</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
	</div>
	
	<div class="fill_message">
	
		<form name="ctl00" action="${pageContext.request.contextPath}/address/insertAddress"
			method="post" id="f" onsubmit="return checkForm()">
			<input type="hidden" name="address.id" id="addressId" />
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">收件人姓名：</td>
					<td><input onblur="checkname()" type="text" class="text_input"
						name="address.address_name" id="receiveName" />
						<div class="text_left" id="nameValidMsg">
							<p id="pname">请填写有效的收件人姓名</p>
							<span id="name.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">收件人详细地址：</td>
					<td><input onblur="checkeaddress()" type="text"
						name="address.receive_address" class="text_input" id="fullAddress" />
						<div class="text_left" id="addressValidMsg">
							<p id="paddress">请填写有效的收件人的详细地址</p>
							<span id="address.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">电话</td>
					<td><input onblur="checkphone()" type="text"
						class="text_input" name="address.tel" id="phone" />
						<div class="text_left" id="phoneValidMsg">
							<p id="pphone">请填写有效的收件人的电话</p>
							<span id="telphone.info" style="color:red"></span>
						</div></td>
				</tr>
			</table>

			<div class="login_in">
				<input	id="btnClientRegister" class="button_1" name="submit" type="submit"
					value="添加" />
			</div>
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

