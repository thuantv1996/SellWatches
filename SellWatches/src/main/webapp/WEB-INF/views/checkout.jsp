<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
	<title>Checkout</title>
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
					<li class="active">Checkout</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-ckeckout-->
	<div class="ckeckout">
		<div class="container">
			<div class="ckeck-top heading">
				<h2>CHECKOUT</h2>
			</div>
			<div class="row">
			
				<div class="col-md-6">
					<div class="ckeckout-top">
						<div class="cart-items">
						 <h3>My Shopping Bag (${itemCart.size()})</h3>
							<script>$(document).ready(function(c) {
								$('.close1').on('click', function(c){
									$('.cart-header').fadeOut('slow', function(c){
										$('.cart-header').remove();
									});
									});	  
								});
						   </script>
							<script>$(document).ready(function(c) {
								$('.close2').on('click', function(c){
									$('.cart-header1').fadeOut('slow', function(c){
										$('.cart-header1').remove();
									});
									});	  
								});
						   </script>
						   <script>$(document).ready(function(c) {
								$('.close3').on('click', function(c){
									$('.cart-header2').fadeOut('slow', function(c){
										$('.cart-header2').remove();
									});
									});	  
								});
						   </script>
							
							<div class="in-check" >
								<ul class="unit">
									<li class="li_Item"><span>Item</span></li>
									<li class="li_ProductName"><span>Product Name</span></li>		
									<li class="li_Price"><span>Price</span></li>
									<li class="li_Quantity"><span>Quantity</span></li>
									<li> </li>
									<div class="clearfix"> </div>
								</ul>
								<c:forEach var="item" items="${itemCart}">
									<ul class="cart-header">
											<div class="delete_cart close1"> </div>
											<li data-id=${item.getId() } class="cart_Img" class="ring-in">
												<a href="<c:url value="/ProductDetail?id=${item.getId()}" />" >
													<img src="<c:url value="/resources/images/HINHLON/${item.getImgProduct()}" />" class="img-responsive" alt="">
												</a>
											</li>
											<li class="cart_ProductName"><span class="name">${item.getProductName()}</span></li>
											<li class="cart_Price" data-price="<fmt:formatNumber type="number" groupingUsed = "false" value="${item.getPrice()}" />"><span class="cost"><fmt:formatNumber type="number" pattern="###,###" value="${item.getPrice()*item.getQuantity()}" /> VNĐ</span></li>
											<li class="cart_Quantity">
												<input class="idQuantity" type="number" min="1" name="quantity_cart" value="${item.getQuantity()}">
											</li>
										<div class="clearfix"> </div>
									</ul>
								</c:forEach>
							</div>
						</div>  
				 	</div>
				 	
				 	<div class="row">
						<div class="col-md-6">
							<span class="txtToTal">Tổng cộng</span>
						</div>
						<div class="col-md-6">
							<span class="txtVND">VND</span>
							<span class="txtPrice" data-checkout="0">
								0₫
							</span>
						</div>
				 	</div>
				</div>
				
				<div class="col-md-6">
					<div class="main">
						<div class="main-content">
							<div class="step">
								<div class="step-sections " step="1">
			
			
									<div class="section">
										<div class="section-header">
											<h2 class="section-title">Thông tin giao hàng</h2>
										</div>
										<div class="section-content section-customer-information no-mb">
			
											<input name="utf8" type="hidden" value="✓">
											<div class="inventory_location_data">
			
												<input name="customer_shipping_district" type="hidden" value="" />
												<input name="customer_shipping_ward" type="hidden" value="" />
			
											</div>
			
			
											<p class="section-content-text">
												Bạn đã có tài khoản? <a
													href="<c:url value="/Login" />">Đăng
													nhập</a>
											</p>
			
			
											<div class="fieldset">
			
												<div class="field   ">
													<div class="field-input-wrapper">
														<label class="field-label" for="billing_address_full_name">Họ
															và tên</label> <input placeholder="Họ và tên" autocapitalize="off"
															spellcheck="false" class="field-input" size="30" type="text"
															id="billing_address_full_name"
															name="billing_address[full_name]" value="" />
													</div>
			
												</div>
			
												<div class="field  field-two-thirds  ">
													<div class="field-input-wrapper">
														<label class="field-label" for="checkout_user_email">Email</label>
														<input placeholder="Email" autocapitalize="off"
															spellcheck="false" class="field-input" size="30"
															type="email" id="checkout_user_email"
															name="checkout_user[email]" value="" />
													</div>
			
												</div>
			
												<div class="field field-required field-third">
													<div class="field-input-wrapper">
														<label class="field-label" for="billing_address_phone">Số
															điện thoại</label> <input placeholder="Số điện thoại"
															autocapitalize="off" spellcheck="false" class="field-input"
															size="30" maxlength="11" type="tel"
															id="billing_address_phone" name="billing_address[phone]"
															value="" />
													</div>
			
												</div>
			
												<div class="field">
													<div class="field-input-wrapper">
														<label class="field-label" for="billing_address_address1">Địa
															chỉ</label> <input placeholder="Địa chỉ" autocapitalize="off"
															spellcheck="false" class="field-input" size="30" type="text"
															id="billing_address_address1"
															name="billing_address[address1]" value="" />
													</div>
			
												</div>
			
											</div>
										</div>
										
										<div id="change_pick_location_or_shipping"></div>
									</div>
			
			
								</div>
								<div class="step-footer">
			
									<form id="form_next_step" accept-charset="UTF-8" method="post">
										<input name="utf8" type="hidden" value="✓">
										<button type="submit" class="step-footer-continue-btn btn">
											<span class="btn-content">Tiếp tục đến phương thức thanh
												toán</span> <i class="btn-spinner icon icon-button-spinner"></i>
										</button>
									</form>
									
								</div>
							</div>
			
						</div>	
					</div>
				</div>
				
			</div>

		</div>
	</div>
	<!--end-ckeckout-->
	<jsp:include page="masterpage_footer.jsp" />
</body>
</html>