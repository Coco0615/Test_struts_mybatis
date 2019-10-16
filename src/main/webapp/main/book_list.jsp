<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>

	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/main/selectAllInMain'>当当图书</a> &gt;&gt;
			<a href="${pageContext.request.contextPath}/main/selectAllByFirstInSecondMain?category_id=${requestScope.category.category_id}">
				<font style='color: #cc3300'><strong>${requestScope.category.category_name}</strong> </font>
			</a>
			<c:if test="${requestScope.categoryName==null}">

				<font style='color: #cc3300'><strong>${requestScope.categoryName}</strong> </font>
			</c:if>
			<c:if test="${requestScope.categoryName!=null}">
				&gt;&gt;
				<font style='color: #cc3300'><strong>${requestScope.categoryName}</strong> </font>
			</c:if>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;全部&nbsp;(${requestScope.category.book_count})
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach var="c" items="${requestScope.category.categories}">
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<div class=second_fenlei>
											<a href="${pageContext.request.contextPath}/main/selectAllBySecondInSecondMain?category_id=${pageScope.c.category_id}">${pageScope.c.category_name}&nbsp;(${pageScope.c.book_count})</a>
										</div>
									</div>
								</li>
						    <div class="clear"></div>
							</c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div id="divTopPageNavi" class="list_r_title_text3">
							<!--分页导航开始-->
							<c:if test="${requestScope.page==1}">
								<div class='list_r_title_text3a'>
										<img src='../images/page_up_gray.gif' />

								</div>
							</c:if>

							<c:if test="${requestScope.page!=1}">
								<div class='list_r_title_text3a'>
									<c:if test="${requestScope.categoryName==null}">
										<a name=link_page_next
										   href="${pageContext.request.contextPath}/main/selectAllByFirstInSecondMain?category_id=${requestScope.category_id}&page=${requestScope.page-1}&rows=${requestScope.rows}">
										<img src='../images/page_up.gif' /> </a>
									</c:if>
									<c:if test="${requestScope.categoryName!=null}">
										<a name=link_page_next
										   href="${pageContext.request.contextPath}/main/selectAllBySecondInSecondMain?category_id=${requestScope.category_id}&page=${requestScope.page-1}&rows=${requestScope.rows}">
										<img src='../images/page_up.gif' /> </a>
									</c:if>

								</div>
							</c:if>


				
							<div class='list_r_title_text3b'>
								第${requestScope.page}页/共${requestScope.pageMax}页
							</div>
							<c:if test="${requestScope.page<requestScope.pageMax}">
								<div class='list_r_title_text3a'>
									<c:if test="${requestScope.categoryName==null}">
										<a name=link_page_next
										   href="${pageContext.request.contextPath}/main/selectAllByFirstInSecondMain?category_id=${requestScope.category_id}&page=${requestScope.page+1}&rows=${requestScope.rows}">
											<img src='../images/page_down.gif' /> </a>
									</c:if>
									<c:if test="${requestScope.categoryName!=null}">
										<a name=link_page_next
										   href="${pageContext.request.contextPath}/main/selectAllBySecondInSecondMain?category_id=${requestScope.category_id}&page=${requestScope.page+1}&rows=${requestScope.rows}">
											<img src='../images/page_down.gif' /> </a>
									</c:if>

								</div>

							</c:if>

							<c:if test="${requestScope.page > requestScope.pageMax}">
								<div class='list_r_title_text3a'>
									<img src='../images/page_down_gray.gif' />
								</div>
							</c:if>
							<c:if test="${requestScope.page == requestScope.pageMax}">
								<div class='list_r_title_text3a'>
									<img src='../images/page_down_gray.gif' />
								</div>
							</c:if>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>



				<c:forEach var="book" items="${requestScope.firstBooks}">
					<div class="clear"></div>
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='${pageContext.request.contextPath}/main/selectBookById?book_id=${pageScope.book.book_id}'>
								<img src="../productImages/${pageScope.book.book_img}" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='${pageContext.request.contextPath}/main/selectBookById?book_id=${pageScope.book.book_id}'>${pageScope.book.book_name}</a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'>${pageScope.book.author}</a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'>新华出版社</a>
							</h4>
							<h4>
								出版时间：<fmt:formatDate value="${pageScope.book.publishTime}" pattern="yyyy/MM/dd"/>
							</h4>
							<h5>
									${pageScope.book.description}
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${pageScope.book.book_price}</span>
								<span class="red">￥${pageScope.book.dang_price}</span>
								节省：￥${pageScope.book.book_price - pageScope.book.dang_price }
							</h6>
							<span class="list_r_list_button"> 
							<a  >
							<img onclick="f(this)" a1="${pageScope.book.book_id}" src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
				</c:forEach>
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
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
