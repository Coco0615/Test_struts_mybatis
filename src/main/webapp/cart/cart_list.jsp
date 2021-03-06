<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function f(id) {
				var count = document.querySelector("input[name=count"+id+"]").value;
				window.location.href="${pageContext.request.contextPath}/cart/updateBuyCountByCartId?cart_id="+id+"&count="+count;
			}
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />

		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>封面</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>

                      <!-- 购物列表开始 -->
					<c:forEach var="cart" items="${requestScope.carts}">
						<tr class='td_no_bord'>
							<td class="buy_td_6">
								<span><img src="${pageContext.request.contextPath}/productImages/${pageScope.cart.book.book_img}" height="50px" width="58px"/></span>
							</td>
							<td>
								<span class="span_w1"><a href="#">${pageScope.cart.book.book_name}</a></span>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥${pageScope.cart.book.book_price}</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥${pageScope.cart.book.dang_price}</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;${pageScope.cart.buy_count}
							</td>
							<td >
								<input name="count${pageScope.cart.cart_id}" class="del_num" type="text" size="3" maxlength="4"/>
								<a onclick="f(${pageScope.cart.cart_id})">变更</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/cart/deleteCartById?cart_id=${pageScope.cart.cart_id}">删除</a>
							</td>
						</tr>
					</c:forEach>
					<!-- 购物列表结束 -->
				</table>
				<div id="div_no_choice" class="objhide">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='${pageContext.request.contextPath}/main/selectAllInMain'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${requestScope.chajia}</span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>

							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${requestScope.sumPrice}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='${pageContext.request.contextPath}/order/verifyOrder' >
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 用户删除恢复区 -->


		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>

				<c:forEach var="deleteCart" items="${requestScope.deleteCarts}">
					<tr>
						<td width="58" class=buy_td_6>
							<span><img src="${pageContext.request.contextPath}/productImages/${pageScope.deleteCart.book.book_img}" height="50px" width="58px"/></span>
						</td>
						<td width="365" class=t2>
							<a href="#">${pageScope.deleteCart.book.book_name}</a>
						</td>
						<td width="106" class=buy_td_5>
							￥${pageScope.deleteCart.book.book_price}
						</td>
						<td width="134" class=buy_td_4>
							<span>￥${pageScope.deleteCart.book.dang_price}</span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="${pageContext.request.contextPath}/cart/undelete?cart_id=${pageScope.deleteCart.cart_id}">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
				</c:forEach>


					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>


				</tbody>
			</table>
		</div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



