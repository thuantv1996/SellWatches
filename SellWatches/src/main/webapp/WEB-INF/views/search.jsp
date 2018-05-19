
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Search</title>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="masterpage_header.jsp" />
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="index.html">Home</a></li>
					<li class="active">Search</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--prdt-starts-->
	<div class="prdt">
		<div class="container">
			<div class="prdt-top">
				<div class="col-md-12 prdt-left">
					<div class="product-one">
						<c:forEach var="item" items="${viewModel.getProducts()}">
							<div class="col-md-3 product-left p-left">
								<div class="product-main simpleCart_shelfItem">
									<a href="single.html" class="mask"><img
										class="img-responsive zoom-img"
										src="<c:url value="/resources/images/HINHLON/${item.getProduct().getBigImage()}" />"
										alt="" /></a>
									<div class="product-bottom">
										<h3>${item.getProduct().getNameProduct()}</h3>
										<p>Explore Now</p>
										<h4>
											<a class="item_add" href="#"><i></i></a> <span
												class=" item_price"><fmt:formatNumber type="number"
													pattern="###,###"
													value="${item.getProduct().getPrice()*(100 - item.getPromotion())/100}" />
												VNĐ</span>
										</h4>
									</div>
									<div class="srch srch1">
										<span>${item.getPromotion()} %</span>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- Phan trang -->
				<div>
					<nav aria-label="Page navigation example">
						<ul class="pagination" style="padding: 15px 15px 15px 15px">
							<c:if test="${viewModel.getCurPage() > 1}">
								<li class="page-item"><a class="page-link"
									href="<c:url value='/search?key=${viewModel.getKey()}&page=${viewModel.getCurPage()-1}' />"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
							</c:if>
							<c:forEach begin='${viewModel.getBeginIndex()}'
								end='${viewModel.getEndIndex()}' var="i">
								<c:choose>
									<c:when test="${i == viewModel.getCurPage()}">
										<li class="page-item"><a class="page-link active"
											href="<c:url value='/search?key=${viewModel.getKey()}&page=${i}' />">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="<c:url value='/search?key=${viewModel.getKey()}&page=${i}' />">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${viewModel.getCurPage() < viewModel.getTotalPage()}">
								<li class="page-item"><a class="page-link"
									href="<c:url value='/search?key=${viewModel.getKey()}&page=${viewModel.getCurPage()+1}' />"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!--product-end-->
	<jsp:include page="masterpage_footer.jsp" />
</body>
</html>