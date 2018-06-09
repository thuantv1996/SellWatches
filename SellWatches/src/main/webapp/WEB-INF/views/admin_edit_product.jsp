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
						Input</li>
				</ol>
				<!--grid-->
				<div class="grid-form">
					<div class="grid-form1">
						<h2 id="forms-example" class="">Edit Product</h2>
						<form:form method="POST" action="edit" enctype="multipart/form-data">
							<div class="form-group">
								<input type="hidden" name = "id" value="${product.getId()}"/>
								<label for="exampleInputEmail1">Name product</label>
								<input type="text" class="form-control" name = "nameProduct"
									placeholder="Name product" value="${product.getNameProduct()}"/>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Description</label>
								<input type="text" class="form-control"
									placeholder="Description" name = "description"
									value="${product.getDescription()}"
									/>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Evalute</label> <textarea
									cols="5"
									rows="3"
									class="form-control" 
									placeholder="Evalute"
									name = "evalute"
									>${product.getEvalute()}</textarea>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Price</label> <input
									type="text" class="form-control" 
									placeholder="Price"
									name= "price"
									value="${product.getPrice() }"/>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Number: </label> <label name="number" >
									${product.getNumber()}</label>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Trademark</label>
								<select class="form-control" name = "idTrademark" >
									<c:forEach items="${trademarks}" var="item">
										<option  value="${item.getId()}">${item.getName()}</option>
									</c:forEach>
								</select>
								<input type="hidden" value="" name = trademark/>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Category</label>
								<select class="form-control" name = "idCategory">
									<c:forEach items="${categories}" var="item">
										<option  value="${item.getId()}">${item.getNameCategory()}</option>
									</c:forEach>
								</select>
								<input type="hidden" value="" name = category/>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Big image</label>
								<input type="file" name = "fileBigImg">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Smail image</label>
								<input type="file" name = "fileSmall">
								<input type="file" name = "fileSmall">
								<input type="file" name = "fileSmall">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
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
			Â© 2016 Pooled . All Rights Reserved | Design by <a
				href="http://w3layouts.com/" target="_blank">W3layouts</a>
		</p>
	</div>
	<!--COPY rights end here-->
	<!--//content-inner-->
	<jsp:include page="admin_masterpage_sidebarmenu.jsp" />
	<div class="clearfix"></div>
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
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
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
	<script src="<c:url value="/resources/admin_js/scripts.js" />"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/admin_js/bootstrap.min.js" />"></script>
	<!-- /Bootstrap Core JavaScript -->

</body>
</html>