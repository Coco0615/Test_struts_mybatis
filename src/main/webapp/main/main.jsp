<%@page contentType="text/html;charset=utf-8"%>
<%@page isELIgnored="false" import="entity.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当图书 – 全球最大的中文网上书店</title>
<link href="../css/book.css" rel="stylesheet" type="text/css" />
<link href="../css/second.css" rel="stylesheet" type="text/css" />
<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />

</head>
<body>
	&nbsp;
	<!-- 头部开始 -->
	<%@include file="../common/head.jsp"%>
	<!-- 头部结束 -->
	<div style="width: 962px; margin: auto;">
		<a href="#" target="_blank"><img
			src="../images/default/book_banner_081203.jpg" border="0" /> </a>
	</div>

	<div class="book">

		<!--左栏开始-->
		<div id="left" class="book_left">
			<div class="book_l_border1" id="__FenLeiLiuLan">
				<div class="book_sort_tushu">
					<h2>分类浏览</h2>

					<!--1级分类开始-->
					<c:forEach var="c" items="${requestScope.cs}">
					<div class="bg_old" onmouseover="this.className = 'bg_white';"
						onmouseout="this.className = 'bg_old';">
						<h3>
							[<a href='${pageContext.request.contextPath}/main/selectAllByFirstInSecondMain?category_id=${pageScope.c.category_id}'>${pageScope.c.category_name}</a>]
						</h3>

						<ul class="ul_left_list">
							<!--2级分类开始-->
							<c:forEach var="c2" items="${pageScope.c.categories}">
							<li><a href='${pageContext.request.contextPath}/main/selectAllBySecondInSecondMain?category_id=${pageScope.c2.category_id}'>${pageScope.c2.category_name}</a></li>
							<!--2级分类结束-->
							</c:forEach>
						</ul>

						<div class="empty_left"></div>
					</div>

					<div class="more2"></div>
					</c:forEach>

					<!--1级分类结束-->

					<div class="bg_old">
						<h3>&nbsp;</h3>
					</div>
				</div>
			</div>

		</div>
		<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">

			<!--推荐图书开始-->
			<div class=second_c_border1 id="recommend">

				<h2>
					<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a>
					</span>编辑推荐
				</h2>
				<div id=__bianjituijian/danpin>
					<div class=second_c_02>

						<!--编辑推荐开始-->
						<c:forEach var="book" items="${requestScope.editorbooks}">
						<div class=second_c_02_b1>
							<div class=second_c_02_b1_1>
								<a href='${pageContext.request.contextPath}/main/selectBookById?book_id=${pageScope.book.book_id}' target='_blank'><img src="../productImages/${pageScope.book.book_img}" width=70 border=0 />
								</a>
							</div>
							<div class=second_c_02_b1_2>
								<h3>
									<a href='${pageContext.request.contextPath}/main/selectBookById?book_id=${pageScope.book.book_id}' target='_blank' title=''>${pageScope.book.book_name}</a>
								</h3>
								<h4>
									作者：${pageScope.book.author} 著 <br />
									出版社：新华出版社&nbsp;&nbsp;&nbsp;&nbsp;出版时间：<fmt:formatDate value="${pageScope.book.publishTime}" pattern="yyyy/MM/dd"/>
								</h4>
								<h5>${pageScope.book.description}</h5>
								<h6>定价：${pageScope.book.book_price} &nbsp;&nbsp;当当价： ${pageScope.book.dang_price}</h6>
								<div class=line_xx></div>
							</div>
						</div>

						</c:forEach>

						<!--编辑推荐结束-->

					</div>
				</div>
			</div>

			<!--推荐图书结束-->

			<!--热销图书开始-->
			<div class="book_c_border2" id="hot">
				<h2>
					<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a>
					</span>热销图书
				</h2>
				<div class="book_c_04">
					<!--热销图书A开始-->
					<c:forEach var="salebook" items="${requestScope.salebooks}">
						<div class="second_d_wai">
							<div class="img">
								<a href="${pageContext.request.contextPath}/main/selectBookById?book_id=${pageScope.salebook.book_id}" target='_blank'><img src="../productImages/${pageScope.salebook.book_img}" border=0 /> </a>
							</div>
							<div class="shuming">
								<a href="${pageContext.request.contextPath}/main/selectBookById?book_id=${pageScope.salebook.book_id}" target="_blank">${pageScope.salebook.book_name}</a><a href="#" target="_blank"></a>
							</div>
							<div class="price">定价：${pageScope.salebook.book_price}</div>
							<div class="price">当当价：${pageScope.salebook.dang_price}</div>
						</div>
						<div class="book_c_xy_long"></div>
					</c:forEach>
					<!--热销图书A结束-->
				</div>
				<div class="clear"></div>
			</div>
			<!--热销图书结束-->

			<!--最新上架图书开始-->
			<div class="book_c_border2" id="new">
				<h2>
					<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a>
					</span>最新上架图书
				</h2>
				<div class="book_c_04">
					<!--最新上架图书A开始-->
					<c:forEach var="newBook" items="${requestScope.newbooks}">
						<div class="second_d_wai">
							<div class="img">
								<a href="${pageContext.request.contextPath}/main/selectBookById?book_id=${pageScope.newBook.book_id}" target='_blank'><img src="../productImages/${pageScope.newBook.book_img}" border=0 /> </a>
							</div>
							<div class="shuming">
								<a href="#" target="_blank">${pageScope.newBook.author}</a><a href="#" target="_blank"></a>
							</div>
							<div class="price">定价：${pageScope.newBook.book_price}</div>
							<div class="price">当当价：${pageScope.newBook.dang_price}</div>
						</div>
						<div class="book_c_xy_long"></div>
					</c:forEach>
					<!--最新上架图书A结束-->
				</div>
				<div class="clear"></div>
			</div>
			<!--最新上架图书结束-->

			<div class="clear"></div>
		</div>
		<!--中栏结束-->



		<!--右栏开始-->
		<div class="book_right">
			<div class="book_r_border2" id="__XinShuReMai">
				<div class="book_r_b2_1x" id="new_bang">
					<h2 class="t_xsrm">新书热卖榜</h2>
					<div id="NewProduct_1_o_t" onmouseover="">
						<h3 class="second">
							<ul>
                                <c:forEach var="newAndSaleBook" items="${requestScope.newandsalebooks}">
									<li><a href="${pageContext.request.contextPath}/main/selectBookById?book_id=${pageScope.newAndSaleBook.book_id}" target='_blank'>${pageScope.newAndSaleBook.book_name}</a></li>
                                </c:forEach>
							</ul>


							<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
						</h3>
					</div>
				</div>
			</div>
		</div>
		<!--右栏结束-->
		<div class="clear"></div>
	</div>

	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>
