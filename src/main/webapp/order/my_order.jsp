<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<title>订单</title>
		<link rel="stylesheet"href="../css/dingdan.css"type="text/css">
	</head>
<body>
<table class="table-head table-mod">
	<tbody>
	<tr>
		<th width="331px">宝贝</th>
		<th>单价</th>
		<th>数量</th>
		<th>实付款</th>
		<th>交易状态</th>
	</tr>
	</tbody>
</table>
<c:forEach var="order" items="${requestScope.orders}">
	<c:if test="${pageScope.order.order_state==0}">
		<div class="dom">
			<label>
						<span class="time">
							<input type="checkbox"/>
							<span class="time"><fmt:formatDate value="${pageScope.order.order_time}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate> </span>
						</span>
				<span>
							<span>订单号</span>
							<span>:</span>
							<span>${pageScope.order.order_id}</span>
						</span>
			</label>
		</div>

		<table class="tb">
			<c:forEach var="item" items="${pageScope.order.items}" varStatus="vs">
				<tr>
					<td width="330px">
						<div style="display: block;">
							<img src="../productImages/${pageScope.item.book.book_img}" style="float: left;"/>
							<p style="width: 230px; margin-left:10px; float: left;">
								<a href="javascript:void(0)"><span class="sp">${pageScope.item.book.book_name}</span></a>
							</p>
						</div>
					</td>
					<td width="238px" align="center">
						<div>
							<p>$${pageScope.item.dang_price}</p>
						</div>
					</td>
					<td width="238px" align="center">${pageScope.item.buy_count}</td>
					<c:if test="${vs.count==1}">
						<td class="boder" rowspan="${pageScope.order.items.size()}">${pageScope.order.total_price}</td>
						<td class="boder" width="239px" rowspan="${pageScope.order.items.size()}">

							<div>
								<p>未支付</p>
								<p><a href="${pageContext.request.contextPath}/alipay.trade.page.pay.jsp?WIDout_trade_no=${pageScope.order.order_id}&WIDtotal_amount=${pageScope.order.total_price}&WIDsubject='订单名称'&WIDbody=''">去支付</a> </p>
							</div>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</c:forEach>

<c:forEach var="order" items="${requestScope.orders}">
	<c:if test="${pageScope.order.order_state==1}">
		<div class="dom">
			<label>
						<span class="time">
							<input type="checkbox"/>
							<span class="time">${pageScope.order.order_time}</span>
						</span>
				<span>
							<span>订单号</span>
							<span>:</span>
							<span>${pageScope.order.order_id}</span>
						</span>
			</label>
		</div>

		<table class="tb">
			<c:forEach var="item" items="${pageScope.order.items}" varStatus="vs">
				<tr>
					<td width="330px">
						<div style="display: block;">
							<img src="../productImages/${pageScope.item.book.book_img}" style="float: left;"/>
							<p style="width: 230px; margin-left:10px; float: left;">
								<a href="javascript:void(0)"><span class="sp">${pageScope.item.book.book_name}</span></a>
							</p>
						</div>
					</td>
					<td width="238px" align="center">
						<div>
							<p>$${pageScope.item.dang_price}</p>
						</div>
					</td>
					<td width="238px" align="center">${pageScope.item.buy_count}</td>
					<c:if test="${vs.count==1}">
						<td class="boder" rowspan="${pageScope.order.items.size()}">${pageScope.order.total_price}</td>
						<td class="boder" width="239px" rowspan="${pageScope.order.items.size()}">

							<div>
								<p>已支付</p>
								<p>交易成功</p>
							</div>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</c:forEach>

<div style="margin: 50px;text-align: center;">
	<a href="javascript:history.go(-1);">
		<input 	class="button_1"  type="button" value="取消" /></a>
</div>
</body>
</html>