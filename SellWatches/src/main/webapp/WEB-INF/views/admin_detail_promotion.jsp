<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web
	Template | Input :: w3layouts</title>
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
						class="fa fa-angle-right"></i>Forms <i class="fa fa-angle-right"></i>
						Input
					</li>
				</ol>
				<!--grid-->
				<div class="grid-form">
					<div class="grid-form1">
						<h2 id="forms-example" class="">Detail promotion</h2>
						<!-- Begin form  -->
						<div>
							<div>
								<input type = "hidden" value="${idPromotion}" id="idPromotion"/>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Product</label> <select
									class="form-control" name="product" id="product">
									<c:forEach items="${products}" var="item">
										<option value="${item.getId()}">${item.getNameProduct()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Percent</label>
								<input type="number" class="form-control" min="0" max="100"
									placeholder="Percent" name="content" id ="content"/>
							</div>
							<button type="submit" class="btn btn-default" onclick="addDetail()">Save</button>
						</div>
						<!-- End form  -->
					</div>
				</div>
				<div class="agile-grids">
					<!-- tables -->
					<div class="agile-tables">
						<div class="w3l-table-info">
							<h2>Detail Promotion</h2>
							<table id="table-breakpoint">
								<thead>
									<tr>
										<th  style="text-align:center">Id product</th>
										<th  style="text-align:center">Product</th>
										<th  style="text-align:center">Percent</th>
										<th  style="text-align:center">Delete</th>
									</tr>
								</thead>
								<tbody id ="content-table">
									<c:forEach items="${detais}" var="item">
										<tr id ="${item.getIdProduct()}" >
											<td style="text-align:center">${item.getIdProduct() }</td>
											<td style="text-align:center">${item.getProduct().getNameProduct() }</td>
											<td style="text-align:center" id="item-content">${item.getContent()}</td>
											<td style="text-align:center"><button type='button' style='background: red;' class='button-delete'>X</button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- //tables -->
				</div>
				
				
				<!--//grid-->

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
							$(".page-container").removeClass(
									"sidebar-collapsed").addClass(
									"sidebar-collapsed-back");
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
		<script
		src="<c:url value="/resources/js/detail.js" />"></script>
	<script src="<c:url value="/resources/admin_js/scripts.js" />"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/admin_js/bootstrap.min.js" />"></script>
	<!-- /Bootstrap Core JavaScript -->
</body>
</html>