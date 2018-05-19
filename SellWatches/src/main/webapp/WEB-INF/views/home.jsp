<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<title>Home</title>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="masterpage_header.jsp" />
	<!--banner-starts-->
	<div class="bnr" id="home">
		<div id="top" class="callbacks_container">
			<ul class="rslides" id="slider4">
				<li><img src="<c:url value="/resources/images/bnr-1.jpg" />"
					alt="" /></li>
				<li><img src="<c:url value="/resources/images/bnr-2.jpg" />"
					alt="" /></li>
				<li><img src="<c:url value="/resources/images/bnr-3.jpg" />"
					alt="" /></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
	<!--banner-ends-->
	<!--Slider-Starts-Here-->
	<script src="<c:url value="/resources/js/responsiveslides.min.js" />"></script>
	<script>
		// You can also use "$(window).load(function() {"
		$(function() {
			// Slideshow 4
			$("#slider4").responsiveSlides({
				auto : true,
				pager : true,
				nav : true,
				speed : 500,
				namespace : "callbacks",
				before : function() {
					$('.events').append("<li>before event fired.</li>");
				},
				after : function() {
					$('.events').append("<li>after event fired.</li>");
				}
			});

		});
	</script>
	<!--End-slider-script-->
	<!--about-starts-->
	<div class="about">
		<div class="container">
			<div class="about-top grid-1">
				<c:forEach var="item" items="${lstSellingProduct}">
					<div class="col-md-4 about-left">
						<figure class="effect-bubba">
							<img class="img-responsive"
								src="<c:url value="/resources/images/HINHLON/${item.getBigImage()}" />" alt="" />
							<figcaption>
								<h2>${item.getNameProduct()}</h2>
								<p>${item.getDescription()} </p>
							</figcaption>
						</figure>
					</div>
				</c:forEach>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--about-end-->
	<!--product-starts-->
	<div class="product">
		<div class="container">
			<div class="product-top">
				<div class="product-one">
					<c:forEach var="item" items="${lstNewProduct.subList(0, 4)}">
						<div class="col-md-3 product-left">
							<div class="product-main simpleCart_shelfItem">
								<a href="<c:url value="/ProductDetail?id=${item.getProduct().getId()}" />" class="mask"><img
									class="img-responsive zoom-img"
									src="<c:url value="/resources/images/HINHLON/${item.getProduct().getBigImage()}" />" alt="" /></a>
								<div class="product-bottom">
									<h3>${item.getProduct().getNameProduct()}</h3>
									<p>Explore Now</p>
									<h4>
										<a class="item_add" href="#"><i></i></a> <span
											class=" item_price"><fmt:formatNumber type="number" pattern="###,###" value="${item.getProduct().getPrice()*(100 -item.getPromotion())}" /> VNĐ</span>
									</h4>
								</div>
								<div class="srch">
									<span>-${item.getPromotion()}%</span>
								</div>
							</div>
						</div>
					</c:forEach>			
					<div class="clearfix"></div>
				</div>
				<div class="product-one">
					<c:forEach var="item" items="${lstNewProduct.subList(4, 8)}">
						<div class="col-md-3 product-left">
							<div class="product-main simpleCart_shelfItem">
								<a href="<c:url value="/ProductDetail?id=${item.getProduct().getId()}" />" class="mask"><img
									class="img-responsive zoom-img"
									src="<c:url value="/resources/images/HINHLON/${item.getProduct().getBigImage()}" />" alt="" /></a>
								<div class="product-bottom">
									<h3>${item.getProduct().getNameProduct()}</h3>
									<p>Explore Now</p>
									<h4>
										<a class="item_add" href="#"><i></i></a> <span
											class=" item_price"><fmt:formatNumber type="number" pattern="###,###" value="${item.getProduct().getPrice()*(100 -item.getPromotion())}" /> VNĐ</span>
									</h4>
								</div>
								<div class="srch">
									<span>-${item.getPromotion()}%</span>
								</div>
							</div>
						</div>
					</c:forEach>	
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--product-end-->
	<jsp:include page="masterpage_footer.jsp" />
</body>
</html>