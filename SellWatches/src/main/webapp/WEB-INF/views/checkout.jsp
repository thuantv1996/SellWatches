<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
			<div class="ckeckout-top">
			<div class="cart-items">
			 <h3>My Shopping Bag (3)</h3>
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
					<li><span>Item</span></li>
					<li><span>Product Name</span></li>		
					<li><span>Unit Price</span></li>
					<li><span>Delivery Details</span></li>
					<li> </li>
					<div class="clearfix"> </div>
				</ul>
				<ul class="cart-header">
					<div class="close1"> </div>
						<li class="ring-in"><a href="single.html" ><img src="<c:url value="/resources/images/c-1.jpg" />" class="img-responsive" alt=""></a>
						</li>
						<li><span class="name">Analog Watches</span></li>
						<li><span class="cost">$ 290.00</span></li>
						<li><span>Free</span>
						<p>Delivered in 2-3 business days</p></li>
					<div class="clearfix"> </div>
				</ul>
				<ul class=" cart-header1">
					<div class="close2"> </div>
						<li class="ring-in"><a href="single.html" ><img src="<c:url value="/resources/images/c-2.jpg" />" class="img-responsive" alt=""></a>
						</li>
						<li><span class="name">Analog Watches</span></li>
						<li><span class="cost">$ 300.00</span></li>
						<li><span>Free</span>
						<p>Delivered in 2-3 business days</p></li>
						<div class="clearfix"> </div>
				</ul>
				<ul class="cart-header2">
					<div class="close3"> </div>
						<li class="ring-in"><a href="single.html" ><img src="<c:url value="/resources/images/c-3.jpg" />" class="img-responsive" alt=""></a>
						</li>
						<li><span class="name">Analog Watches</span></li>
						<li><span class="cost">$ 360.00</span></li>
						<li><span>Free</span>
						<p>Delivered in 2-3 business days</p></li>
						<div class="clearfix"> </div>
				</ul>
			</div>
			</div>  
		 </div>
		</div>
	</div>
	<!--end-ckeckout-->
	<jsp:include page="masterpage_footer.jsp" />
</body>
</html>