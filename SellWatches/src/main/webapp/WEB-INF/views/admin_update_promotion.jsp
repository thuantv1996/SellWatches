<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add promotion</title>
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
						class="fa fa-angle-right"></i>Update promotion <i class="fa fa-angle-right"></i>
						</li>
				</ol>
				<!--grid-->
				<div class="grid-form">
					<div class="grid-form1">
						<h2 id="forms-example" class="">Update promotion</h2>
						<c:if test="${error.size()>0}">
							<div id = "error-label">
								<c:forEach items="${error}" var = "i">
									<label style="color:red;"><i>* ${i}</i></label>
									<br />
								</c:forEach>
							</div>
						</c:if>
						<form:form method="POST" action="/SellWatches/admin/promotion/update"
							modelAttribute="promotion">
							<div class="form-group">
								<form:input type="hidden" class="form-control" path="id" />
								<label for="exampleInputEmail1">Name promotion</label>
								<form:input type="text" class="form-control" path="namePromotion"
									placeholder="Name promotion"></form:input>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Begin date</label>
								<form:input type="date" class="form-control" path="beginDay" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">End date</label>
								<form:input type="date" class="form-control" path="endDay" />
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form:form>
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
	<script src="<c:url value="/resources/admin_js/scripts.js" />"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/admin_js/bootstrap.min.js" />"></script>
	<!-- /Bootstrap Core JavaScript -->
</body>
</html>