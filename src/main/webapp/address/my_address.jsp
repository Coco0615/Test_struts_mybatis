<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>收获地址管理 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			我的收货地址：
		</div>
		<div class="fill_message">

			<table class="tab_login">

				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人姓名</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人地址</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人联系方式</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货地址状态</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>操作</b>
					</td>
				</tr>

				<!-- 收货地址开始 -->
				<c:forEach var="address" items="${requestScope.addresses}" varStatus="vs">
				<tr>
					<td valign="top">
							${vs.count}
					</td>
					<td valign="top">
						           ${pageScope.address.address_name}
					</td>
					<td valign="top">
						          ${pageScope.address.receive_address}
					</td>
					<td valign="top">
						   ${pageScope.address.tel}
					</td>
					<c:if test="${pageScope.address.default_state==1}">
						<td valign="top">
									默认收货地址
						</td>
					</c:if>
					<c:if test="${pageScope.address.default_state==0}">
						<td valign="top">
							<a href="${pageContext.request.contextPath}/address/updateDefaultAddress?address_id=${pageScope.address.address_id}">设置为默认收货地址</a>
						</td>
					</c:if>
					<td valign="top">
						  <a  href="${pageContext.request.contextPath}/address/deleteAddressById?address_id=${pageScope.address.address_id}">删除</a>
					</td>
				</tr>
				</c:forEach>


				<!--收货地址结束 -->
			</table>
			
			<a href="add_address.jsp">添加新的收获地址</a>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html> 
