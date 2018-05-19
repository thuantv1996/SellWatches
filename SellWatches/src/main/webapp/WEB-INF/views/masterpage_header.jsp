<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<!--top-header-->
	<div class="top-header">
		<div class="container">
			<div class="top-header-main">
				<div class="col-md-6 top-header-left">
					<div class="drop">
						<div class="box">
							<select tabindex="4" class="dropdown drop">
								<option value="" class="label">Dollar :</option>
								<option value="1">Dollar</option>
								<option value="2">Euro</option>
							</select>
						</div>
						<div class="box1">
							<select tabindex="4" class="dropdown">
								<option value="" class="label">English :</option>
								<option value="1">English</option>
								<option value="2">French</option>
								<option value="3">German</option>
							</select>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-4 userMenu">
					<jsp:include page="usermenu.jsp" />
				</div>
				<div class="col-md-2 top-header-left">
					<div class="cart box_1">
						<a href="<c:url value="/Checkout" />">
							<div class="total">
								<span class="simpleCart_total"></span></div>
								<img src="<c:url value="/resources/images/cart-1.png" />" alt="" />
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--top-header-->
	<!--start-logo-->
	<div class="logo">
		<a href="<c:url value="/Index" />"><h1>Luxury Watches</h1></a>
	</div>
	<!--start-logo-->
	<!--bottom-header-->
	<div class="header-bottom">
		<div class="container">
			<div class="header">
				<div class="col-md-9 header-left">
				<div class="top-nav">
					<ul class="memenu skyblue">
						<li class="active">
							<a href="<c:url value="/" />">Home</a>
						</li>
						<li class="grid">
                            <a href="<c:url value="/Products?cateKey=All&page=1" />">Products</a>
                        </li>
						<li class="grid">
							<a href="<c:url value="/Products?cateKey=Men&page=1" />">Men</a>
						</li>
						<li class="grid">
							<a href="<c:url value="/Products?cateKey=Women&page=1" />">Women</a>
						</li>
						<li class="grid">
							<a href="contact.html">Contact</a>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-3 header-right"> 
				<div class="search-bar">
					<form method="get" action="/SellWatches/searchkey">
						<input type="text" name="key" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
						<input type="submit" value="">
					</form>
				</div>
			</div>
			<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--bottom-header-->