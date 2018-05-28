<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web
	Template | Tabels :: w3layouts</title>
<jsp:include page="admin_header.jsp" />
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="mother-grid-inner">
				<jsp:include page="admin_masterpage_header.jsp" />
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a><i
						class="fa fa-angle-right"></i>Products</li>
				</ol>
				<div class="agile-grids">
					<!-- tables -->

					<div class="agile-tables">
						<div class="w3l-table-info">
							<h2>Products</h2>
							<table id="table-breakpoint">
								<thead>
									<tr>
										<th>Name</th>
										<th>trademark</th>
										<th>Images</th>
										<th>description</th>
										<th>price</th>
										<th>number</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${products}">
										<tr>
											<td>${item.getNameProduct()}</td>
											<td>${item.getTrademark().getName()}</td>
											<td>
												<img class="img-responsive"
														src="<c:url value="/resources/images/HINHLON/${item.getBigImage()}" />" alt="" />
											</td>
											<td>${item.getDescription()}</td>
											<td><fmt:formatNumber type="number" pattern="###,###" value="${item.getPrice()}" /> VNĐ</td>
											<td>${item.getNumber()}</td>
											<td><a href="products/edit?id=${item.getId() }">edit</a></td>
											<td><a href="products/delete?id=${item.getId()}&page=${page}" onclick="return confirm('Are you sure?')">delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<c:choose>
						<c:when test="${numberPage >= 1}">
							<nav aria-label="Page navigation example">
		                        <ul class="pagination" style="padding: 15px 15px 15px 15px">
		                            <c:if test="${page > 1}">
		                            	<li class="page-item">
		                                    <a class="page-link" href="<c:url value='products?page=${page-1}' />" aria-label="Previous">
		                                        <span aria-hidden="true">&laquo;</span>
		                                        <span class="sr-only">Previous</span>
		                                    </a>
		                                </li>
		                            </c:if>
		                            <c:forEach begin='${pageBegin}' end='${pageEnd}' var="i">
			                            <c:choose>
			                            	<c:when test="${i == page}">
			                            		<li class="page-item"><a class="page-link active" href="<c:url value='products?page=${i}' />">${i}</a></li>
			                            	</c:when>
			                            	<c:otherwise>
			                            		<li class="page-item"><a class="page-link" href="<c:url value='products?page=${i}' />">${i}</a></li>
			                            	</c:otherwise>
			                            </c:choose>
		                            </c:forEach>
		                            <c:if test="${page != numberPage}">
		                            	<li class="page-item">
		                                    <a class="page-link" href="<c:url value='products?page=${page+1}' />" aria-label="Next">
		                                        <span aria-hidden="true">&raquo;</span>
		                                        <span class="sr-only">Next</span>
		                                    </a>
		                                </li>
		                            </c:if>
		                        </ul>
		                    </nav>
						</c:when>
						<c:otherwise>
							<span>Không có sản phẩm nào</span>
						</c:otherwise>
					</c:choose>
					<!-- //tables -->
				</div>
				<!-- script-for sticky-nav -->
				<script>
					$(document).ready(function() {
						var navoffeset = $(".header-main").offset().top;
						$(window).scroll(function() {
							var scrollpos = $(window).scrollTop();
							if (scrollpos >= navoffeset) {
								$(".header-main").addClass("fixed");
							} else {
								$(".header-main").removeClass("fixed");
							}
						});

					});
				</script>
				<!-- /script-for sticky-nav -->
				<!--inner block start here-->
				<div class="inner-block"></div>
				<!--inner block end here-->
				<!--copy rights start here-->
				<div class="copyrights">
					<p>
						The world of the lock | the world of the technology<a
							href="/SellWatches/" target="_blank"> LUXURY WATCHES</a>
					</p>
				</div>
				<!--COPY rights end here-->
			</div>
		</div>
		<!--//content-inner-->
		<jsp:include page="admin_masterpage_sidebarmenu.jsp" />
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!--js -->
	<script
		src="<c:url value="/resources/admin_js/jquery.nicescroll.js" />"></script>
	<script src="<c:url value="/resources/admin_js/scripts.js" />"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/admin_js/bootstrap.min.js" />"></script>
	<!-- /Bootstrap Core JavaScript -->

</body>
</html>