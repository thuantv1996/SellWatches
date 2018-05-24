<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Gallery :: w3layouts</title>
<jsp:include page="admin_header.jsp" />
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
              <jsp:include page="admin_masterpage_header.jsp" />
		<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a><i class="fa fa-angle-right"></i>Gallery</li>
            </ol>
<div class="agile3-grids">
		
			<div class="gallery-grids">
				<div class="col-md-6 gallery-grids-left">
					<div class="gallery-grid">
						<a class="example-image-link" href="images/g1.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
							<img src="images/g1.jpg" alt="">
						</a>
					</div>
					<div class="gallery-grids-left-sub">
						<div class="col-md-6 gallery-grids-left-subl">
							<div class="gallery-grid"><a class="example-image-link" href="images/g2.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
									<img src="images/g2.jpg" alt="">
								</a>
							</div>
							<div class="gallery-grid gallery-grid-sub">
								<a class="example-image-link" href="images/g3.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
									<img src="images/g3.jpg" alt="">
								</a>
							</div>
						</div>
						<div class="col-md-6 gallery-grids-left-subr">
							<div class="gallery-grid">
								<a class="example-image-link" href="images/g4.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
									<img src="images/g4.jpg" alt="">
								</a>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="col-md-6 gallery-grids-left">
					<div class="col-md-6 gallery-grids-right">
						<div class="gallery-grid">
							<a class="example-image-link" href="images/g5.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
								<img src="images/g5.jpg" alt="">
							</a>
						</div>
					</div>
					<div class="col-md-6 gallery-grids-right">
						<div class="gallery-grid">
							<a class="example-image-link" href="images/g6.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
								<img src="images/g6.jpg" alt="">
							</a>
						</div>
					</div>
					<div class="clearfix"> </div>
					<div class="gallery-grids-right1">
						<div class="gallery-grid">
							<a class="example-image-link" href="images/g7.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
								<img src="images/g7.jpg" alt="">
							</a>
						</div>
					</div>
					<div class="col-md-6 gallery-grids-right">
						<div class="gallery-grid">
							<a class="example-image-link" href="images/g8.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
								<img src="images/g8.jpg" alt="">
							</a>
						</div>
					</div>
					<div class="col-md-6 gallery-grids-right">
						<div class="gallery-grid">
							<a class="example-image-link" href="images/g9.jpg" data-lightbox="example-set" data-title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae cursus ligula">
								<img src="images/g9.jpg" alt="">
							</a>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
				<script src="js/lightbox-plus-jquery.min.js"> </script>
			</div>
		
	</div>
<!-- script-for sticky-nav -->
		<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
			 
		});
		</script>
		<!-- /script-for sticky-nav -->
<!--inner block start here-->
<div class="inner-block">

</div>
<!--inner block end here-->
<!--copy rights start here-->
<div class="copyrights">
	 <p>Â© 2016 Pooled . All Rights Reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
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
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
<!--js -->
<script src="<c:url value="/resources/admin_js/jquery.nicescroll.js" />"></script>
<script src="<c:url value="/resources/admin_js/scripts.js" />"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="<c:url value="/resources/admin_js/bootstrap.min.js" />"></script>
   <!-- /Bootstrap Core JavaScript -->	     

</body>
</html>