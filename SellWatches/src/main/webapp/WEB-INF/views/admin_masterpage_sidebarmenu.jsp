<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!--/sidebar-menu-->
<div class="sidebar-menu">
	<header class="logo1">
		<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
		</a>
	</header>
	<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
	<div class="menu">
		<ul id="menu">
			<li><a href="<c:url value="/admin/home" />"><i
					class="fa fa-tachometer"></i> <span>Dashboard</span>
				<div class="clearfix"></div></a></li>

			<li id="menu-academico"><a href="#"><i
					class="fa fa-file-text-o"></i> <span>Pages</span> <span
					class="fa fa-angle-right" style="float: right"></span>
				<div class="clearfix"></div></a>
				<ul id="menu-academico-sub">
					<li id="menu-academico-boletim"><a href="calendar.html">Calendar</a></li>
					<li id="menu-academico-avaliacoes"><a href="signin.html">Sign In</a></li>
				</ul>
			</li>
			<li id="menu-academico"><a href="/SellWatches/admin/products?page=1"><i
					class="fa fa-product-hunt"></i> <span>Product</span> <span
					class="fa fa-angle-right" style="float: right"></span>
				<div class="clearfix"></div></a>
				<ul id="menu-academico-sub">
					<li id="menu-academico-boletim"><a href="/SellWatches/admin/products/add">Add Product</a></li>
				</ul>
			</li>
			<li id="menu-academico"><a href="/SellWatches/admin/promotion?page=1"><i
					class="fa fa-arrow-circle-down"></i> <span>Promotion</span> <span
					class="fa fa-angle-right" style="float: right"></span>
				<div class="clearfix"></div></a>
				<ul id="menu-academico-sub">
					<li id="menu-academico-boletim"><a href="/SellWatches/admin/promotion/add">Add promotion</a></li>
				</ul>
			</li>
			<li id="menu-academico"><a href="/SellWatches/admin/order"><i
					class="fa fa-first-order"></i> <span>Order</span>
				<div class="clearfix"></div></a>
			</li>
		</ul>
	</div>
</div>