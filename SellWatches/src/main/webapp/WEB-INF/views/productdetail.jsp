<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Product Detail</title>
<jsp:include page="head.jsp" />	
<script type="text/javascript">
	$(function() {
	
	    var menu_ul = $('.menu_drop > li > ul'),
	           menu_a  = $('.menu_drop > li > a');
	    
	    menu_ul.hide();
	
	    menu_a.click(function(e) {
	        e.preventDefault();
	        if(!$(this).hasClass('active')) {
	            menu_a.removeClass('active');
	            menu_ul.filter(':visible').slideUp('normal');
	            $(this).addClass('active').next().stop(true,true).slideDown('normal');
	        } else {
	            $(this).removeClass('active');
	            $(this).next().stop(true,true).slideUp('normal');
	        }
	    });
	
	});
</script>		
</head>
<body> 
	<jsp:include page="masterpage_header.jsp" />
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="<c:url value="/Index" />">Home</a></li>
					<li class="active">Single</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-single-->
	<div class="single contact">
		<div class="container">
			<div class="single-main">
				<div class="col-md-9 single-main-left">
				<div class="sngl-top">
					<div class="col-md-5 single-top-left">	
						<div class="flexslider">
							  <ul class="slides">
								<li data-thumb="<c:url value="/resources/images/HINHNHO/${viewModel.getProduct().getProduct().getSmallImage()}/1.jpg" />">
									<div class="thumb-image"> <img src="<c:url value="/resources/images/HINHNHO/${viewModel.getProduct().getProduct().getSmallImage()}/1.jpg" />" data-imagezoom="true" class="img-responsive" alt=""/> </div>
								</li>
								<li data-thumb="<c:url value="/resources/images/HINHNHO/${viewModel.getProduct().getProduct().getSmallImage()}/2.jpg" />">
									 <div class="thumb-image"> <img src="<c:url value="/resources/images/HINHNHO/${viewModel.getProduct().getProduct().getSmallImage()}/2.jpg" />" data-imagezoom="true" class="img-responsive" alt=""/> </div>
								</li>
								<li data-thumb="<c:url value="/resources/images/HINHNHO/${viewModel.getProduct().getProduct().getSmallImage()}/3.jpg" />">
								   <div class="thumb-image"> <img src="<c:url value="/resources/images/HINHNHO/${viewModel.getProduct().getProduct().getSmallImage()}/3.jpg" />" data-imagezoom="true" class="img-responsive" alt=""/> </div>
								</li> 
							  </ul>
						</div>
						<!-- FlexSlider -->
						<script src="<c:url value="/resources/js/imagezoom.js" /> "></script>
						<script defer src="<c:url value="/resources/js/jquery.flexslider.js" />"></script>
						<link rel="stylesheet" href="<c:url value="/resources/css/flexslider.css" />" type="text/css" media="screen" />

						<script>
						// Can also be used with $(document).ready()
						$(window).load(function() {
						  $('.flexslider').flexslider({
							animation: "slide",
							controlNav: "thumbnails"
						  });
						});
						</script>
					</div>	
					<div class="col-md-7 single-top-right">
						<div class="single-para simpleCart_shelfItem">
						<h2>${viewModel.getProduct().getProduct().getNameProduct()}</h2>
							<div class="star-on">
								<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
								<div class="review">
									<a href="#">Promotion: ${viewModel.getProduct().getPromotion()} %</a>
									
								</div>
							<div class="clearfix"> </div>
							</div>
							
							<h5 class="item_price"><fmt:formatNumber type="number" pattern="###,###" value="${viewModel.getProduct().getProduct().getPrice()*(100 - viewModel.getProduct().getPromotion())}" /> VNĐ</h5>
							<p>${viewModel.getProduct().getProduct().getDescription()}</p>
							<ul class="tag-men">
								<li><span>TAG</span>
								<span class="women1">: ${viewModel.getProduct().getProduct().getCategory().getNameCategory()},</span></li>
								<li><span>SKU</span>
								<span class="women1">: ${viewModel.getProduct().getProduct().getTrademark().getName()}</span></li>
							</ul>
								<a href="#" class="add-cart item_add">ADD TO CART</a>
							
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="tabs">
					<ul class="menu_drop">
				<li class="item1"><a href="#"><img src="<c:url value="/resources/images/arrow.png" />" alt="">Description</a>
					<ul>
						<li class="subitem1"><a href="#">${viewModel.getProduct().getProduct().getDescription()}</a></li>
					</ul>
				</li>
				
	 		</ul>
				</div>
				<div class="latestproducts">
					<div class="product-one">
						<c:forEach var="item" items="${viewModel.getRelatedProducts()}">
							<div class="col-md-4 product-left">
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
				<div class="col-md-3 single-right">
					<div class="w_sidebar">
						<section  class="sky-form" style="height:865px; overflow:hidden">
							<h4>New Products</h4>
							<div>
	                            <div class="col col-4" style="padding:5px">
	                                <marquee direction="up" vspace="10px" onmouseover="this.stop()" onmouseout="this.start()">
	                                    <c:forEach var="item" items="${viewModel.getNewProducts()}">
	                                        <div class="product-left">
	                                            <div class="product-main simpleCart_shelfItem">
	                                                <a href="<c:url value="/ProductDetail?id=${item.getProduct().getId()}"/>" class="mask">
														<img class="img-responsive zoom-img"
															 src="<c:url value="/resources/images/HINHLON/${item.getProduct().getBigImage()}" />" alt="" />
													</a>
	                                                <div class="product-bottom">
														<h3>${item.getProduct().getNameProduct()}</h3>
														<p>Explore Now</p>
														<h4>
															<a class="item_add" href="#"><i></i></a> <span
																class=" item_price"><fmt:formatNumber type="number" pattern="###,###" value="${item.getProduct().getPrice()*(100 -item.getPromotion())}" /> VNĐ</span>
														</h4>
													</div>				
	                                            </div>
	                                        </div>
	                                        <div style="height:10px"></div>
	                                    </c:forEach>
	                                </marquee>
	                            </div>
	                        </div>
						</section>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--end-single-->
	<jsp:include page="masterpage_footer.jsp" />
</body>
</html>