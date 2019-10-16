<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
ul li {
	text-decoration: none;
	list-style-type: none;
	line-height: 20px;
}

body {
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 12px;
	background: #769b72 url(../images/booksaleimg/bg_grad.gif) top center
		no-repeat;
	cursor: default;
	color: #404040;
	margin: 0;
	padding: 0;
}
	.lastdiv{

		color: whitesmoke;
	}
</style>
	<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>

</head>
<body>
	<div style="width: 60%;margin:20px auto;">
		<div style="width:100%;float: left;">
			<h1>
				
			</h1>
			<span><font color="#cccccc">丛书名：${requestScope.book.book_name}</font></span>
			<hr />
			<div>
				<div style="float: left;width:20%;">
					<img src="../productImages/${requestScope.book.book_img}"  border=0 />
				</div>
				<div style="float: left;width:80%">
					<ul class="info">
						<li>作&nbsp;者：${requestScope.book.author}</li>
						<li>出版社：新华出版社</li>
						<li style="float:left;width:50%;">出版时间：<fmt:formatDate value="${requestScope.book.publishTime}" pattern="yyyy/MM/dd"/></li>
						<li style="float:left;width:50%;">字数：500000</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">版次：第一版</li>
						<li style="float:left;width:50%;">页数：302</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">印刷时间：<fmt:formatDate value="${requestScope.book.publishTime}" pattern="yyyy/MM/dd"/> </li>
						<li style="float:left;width:50%;">开本：16开	</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">印次：5</li>
						<li style="float:left;width:50%;">纸张：A4</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">ISBN：132453</li>
						<li style="float:left;width:50%;">包装：精装</li>
						<li>
							<div class='your_position'>
								您现在的位置:&nbsp; <a href='${pageContext.request.contextPath}/main/selectAllInMain'>当当图书</a>&gt;&gt;图书展示

								<font style='color: #cc3300'> 
									<strong> 
									</strong>
								</font>
							</div>
						</li>
						<li>定价：${requestScope.book.book_price}￥&nbsp;&nbsp;
							当当价：${requestScope.book.dang_price}￥&nbsp;&nbsp; 节省：${requestScope.book.book_price - requestScope.book.dang_price }￥</li>
						<li><a  > <img onclick="f(this)" a1="${requestScope.book.book_id}"
								src='../images/buttom_goumai.gif' class="abc"
								onclick="" />
						</a></li>
					</ul>
				</div>
				<div style="float: clear;"></div>
			</div>
		</div>
	<div class="lastdiv">

		<c:forEach var="comment" items="${requestScope.comments}">
			<c:if test="${requestScope.user.user_id==pageScope.comment.user_id}">
				${pageScope.comment.content}&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${pageScope.comment.comment_time}" pattern="yyyy/MM/dd HH:mm:ss"/> &nbsp;&nbsp;&nbsp;&nbsp;
				${pageScope.comment.user.nick_name}&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/comment/deleteCommentByCommentId?comment_id=${pageScope.comment.comment_id}&book_id=${pageScope.comment.book_id}">删除</a><br/>
			</c:if>
			<c:if test="${requestScope.user.user_id!=pageScope.comment.user_id}">
				${pageScope.comment.content}&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${pageScope.comment.comment_time}" pattern="yyyy/MM/dd HH:mm:ss"/> &nbsp;&nbsp;&nbsp;&nbsp;
				${pageScope.comment.user.nick_name}<br/>
			</c:if>

		</c:forEach>
	</div>
		<form action="${pageContext.request.contextPath}/comment/insertComment">
			<input type="hidden" name="book_id" value="${requestScope.book.book_id}"/>
			<textarea style="background-color: #769b72;border-color: white" name="txt" rows="2" cols="50"></textarea><br/>
			<input id="commit" type="submit" value="提交"/>
		</form>
	</div>
	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
<script type="text/javascript">
	function f(e) {
		var book_id = $(e).attr("a1");
		console.log(book_id);

		$(e).prop("src","../images/load.gif")

		window.setTimeout(function () {
			$(e).prop("src","../images/label3.gif")
		},1000);
		$.ajax({
			url:'${pageContext.request.contextPath}/cart/buy',
			type:'post',
			data:'book_id='+book_id,
			success:function () {
				/*alert("添加成功！");*/
			}
		})
		window.setTimeout(function () {
			$(e).prop("src","../images/buttom_goumai.gif")
		},2000);
	}

</script>
</html>