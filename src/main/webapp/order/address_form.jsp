<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<link href="../css/address.css" rel="stylesheet" type="text/css" />
	<script src="../js/jquery-1.8.3.js"></script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 ><span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">
		 
		 <form action="${pageContext.request.contextPath}/order/insertOrder" method="post">
			 <div class="address-wrap">
				<ul class="address-list">

					<c:forEach var="address" items="${requestScope.addresses}">

						<li class="address-wrap ">
							<c:if test="${pageScope.address.default_state==1}">
								<div class="addressBox">
									<span class="marker-tip">寄送至</span>
								</div>
							</c:if>
							<label class="addressInfo">
								<input type="radio" name="address" value="${pageScope.address.address_id}"/>
								<span class="user-address">
									<span ></span>
									<span>${pageScope.address.receive_address}</span>
									<span>（</span>
									<span>${pageScope.address.address_name}</span>
									<span> 收）</span>
									<em>${pageScope.address.tel}</em>
								</span>
							</label>
						</li>
					</c:forEach>
				</ul>
			</div>
			<a href="${pageContext.request.contextPath}/address/add_address.jsp">添加收货地址</a>
			<div class="login_in">
				<input id="btnClientRegister" class="button_1" name="submit" type="submit"
					value="下一步" />
			</div>
			
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
	<script type="text/javascript">
		$(".addressBox").parents("li").addClass("selected");
		$(".selected").children(".addressInfo").children("input[name=address]").prop("checked","true");
		$("input[name=address]").click(function () {
			$("input[name=address]").parents("li").removeClass();
			$(this).parents("li").addClass("selected");
			$(".addressBox").remove();
			$(".selected").children(".addressInfo").prepend("<div class='addressBox'><span class='marker-tip'>寄送至</span></div>");
		})

	</script>
</body>
</html>

