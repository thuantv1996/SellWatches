<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
	<title>Contact</title>
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
					<li class="active">Contact</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--contact-start-->
	<div class="contact">
		<div class="container">
			<div class="contact-top heading">
				<h2>CONTACT</h2>
			</div>
				<div class="contact-text">
				<div class="col-md-3 contact-left">
						<div class="address">
							<h5>Địa chỉ</h5>
							<p>Watch shop national, 
							<span>Trung tâm thương mại Bitexco,</span>
							Hàm nghi, Quận 1, Thành phố Hồ Chí Minh.</p>
						</div>
						<div class="address">
							<h5>Thông tin liên hệ</h5>
							<p>Tel:1115550001, 
							<span>Fax:190-4509-494</span>
							Email: <a href="mailto:example@email.com">tuvanthuan1996@gmail.com</a></p>
						</div>
					</div>
					<div class="col-md-9 contact-right">
						<form method="post" action="/SellWatches/send">
							<input type="text" placeholder="Name" name = "name" required/>
							<input type="text" placeholder="Phone" name = "phone" required/>
							<input type="email"  placeholder="Email" name = "email" required/>
							<textarea placeholder="Message" required name = "message"></textarea>
							<div class="submit-btn">
								<input type="submit" value="SEND TO US">
							</div>
						</form>
					</div>	
					<div class="clearfix"></div>
				</div>
		</div>
	</div>
	<!--contact-end-->
	<!--map-start-->
	<div class="map">
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.2282350985097!2d106.80113671422733!3d10.870237742257922!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317527587e9ad5bf%3A0xafa66f9c8be3c91!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBDw7RuZyBuZ2jhu4cgVGjDtG5nIHRpbiDEkEhRRy1IQ00!5e0!3m2!1svi!2s!4v1521476884352" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
	</div>
	<!--map-end-->
	<jsp:include page="masterpage_footer.jsp" />
</body>
</html>