
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Products</title>
	<jsp:include page="head.jsp" />				
</head>
<body> 
	<jsp:include page="masterpage_header.jsp" />
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="<c:url value="/" />">Home</a></li>
					<c:choose>
						<c:when test="${productCategoryViewModel.getCateKey().equals('All')}">
							<li class="active">New Products</li>
						</c:when>
						<c:when test="${productCategoryViewModel.getCateKey().equals('Men')}">
							<li class="active">Men</li>
						</c:when>
						<c:when test="${productCategoryViewModel.getCateKey().equals('Women')}">
							<li class="active">Women</li>
						</c:when>
					</c:choose>
					
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
						<c:forEach var="listPr" items="${listProducts.subList(Math.max(Integer.parseInt('0'), Integer.parseInt(productCategoryViewModel.getIndexSublist())), Math.min(Integer.parseInt(listProducts.size()), Integer.parseInt(productCategoryViewModel.getIndexSublist() + 4)))}">
							<div class="col-md-3 product-left p-left">
								<div class="product-main simpleCart_shelfItem">
									<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="<c:url value="/resources/images/HINHLON/${listPr.getBigImage()}" />" alt="" /></a>
									<div class="product-bottom">
										<h3>${listPr.getNameProduct()}</h3>
										<p>Explore Now</p>
										<h4>
											<a class="item_add" href="#"><i></i></a> 
											<span class=" item_price"><fmt:formatNumber type="number" pattern="###,###" value="${listPr.getPrice()}" /> VNĐ</span>
										</h4>
									</div>
									<div class="srch srch1">
										<span>-0%</span>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="clearfix"></div>
					</div>
					<div class="product-one">
						<c:forEach var="listPr" items="${listProducts.subList(Math.min(Integer.parseInt(listProducts.size()), Integer.parseInt(productCategoryViewModel.getIndexSublist() + 4)), Math.min(Integer.parseInt(listProducts.size()), Integer.parseInt(productCategoryViewModel.getIndexSublist() + 8)))}">
							<div class="col-md-3 product-left p-left">
								<div class="product-main simpleCart_shelfItem">
									<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="<c:url value="/resources/images/HINHLON/${listPr.getBigImage()}" />" alt="" /></a>
									<div class="product-bottom">
										<h3>${listPr.getNameProduct()}</h3>
										<p>Explore Now</p>
										<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price"><fmt:formatNumber type="number" pattern="###,###" value="${listPr.getPrice()}" /> VNĐ</span></h4>
									</div>
									<div class="srch srch1">
										<span>-0%</span>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="clearfix"></div>
					</div>	
					<!-- Phân trang sản phẩm -->
					<c:choose>
						<c:when test="${productCategoryViewModel.getTotalPage() > 1}">
							<nav aria-label="Page navigation example">
		                        <ul class="pagination" style="padding: 15px 15px 15px 15px">
		                            <c:if test="${productCategoryViewModel.getIndex() > 1}">
		                            	<li class="page-item">
		                                    <a class="page-link" href="<c:url value='/Products?cateKey=${productCategoryViewModel.getCateKey()}&page=${productCategoryViewModel.getPrev()}' />" aria-label="Previous">
		                                        <span aria-hidden="true">&laquo;</span>
		                                        <span class="sr-only">Previous</span>
		                                    </a>
		                                </li>
		                            </c:if>
		                            <c:forEach begin='${productCategoryViewModel.getStartPageIndex()}' end='${productCategoryViewModel.getEndPageIndex()}' var="i">
			                            <c:choose>
			                            	<c:when test="${i == productCategoryViewModel.getIndex()}">
			                            		<li class="page-item"><a class="page-link active" href="<c:url value='/Products?cateKey=${productCategoryViewModel.getCateKey()}&page=${i}' />">${i}</a></li>
			                            	</c:when>
			                            	<c:otherwise>
			                            		<li class="page-item"><a class="page-link" href="<c:url value='/Products?cateKey=${productCategoryViewModel.getCateKey()}&page=${i}' />">${i}</a></li>
			                            	</c:otherwise>
			                            </c:choose>
		                            </c:forEach>
		                            <c:if test="${productCategoryViewModel.getIndex() != productCategoryViewModel.getTotalPage()}">
		                            	<li class="page-item">
		                                    <a class="page-link" href="<c:url value='/Products?cateKey=${productCategoryViewModel.getCateKey()}&page=${productCategoryViewModel.getNext()}' />" aria-label="Next">
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
				</div>	
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--product-end-->
	<jsp:include page="masterpage_footer.jsp" />
</body>
</html>