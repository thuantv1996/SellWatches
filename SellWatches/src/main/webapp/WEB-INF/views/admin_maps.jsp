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
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Maps :: w3layouts</title>
<jsp:include page="admin_header.jsp" />
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
             <jsp:include page="admin_masterpage_header.jsp" />
		<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a><i class="fa fa-angle-right"></i>Maps</li>
            </ol>
	<div class="map">
		<div class="col-md-6 w3layouts-map">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3320.183033874468!2d150.8649541095356!3d-33.678324494541656!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b129838f39a743f%3A0x3017d681632a850!2sSydney+NSW%2C+Australia!5e0!3m2!1sen!2sin!4v1476529656354"  frameborder="0" style="border:0" allowfullscreen></iframe>
		</div>
		<div class="col-md-6 agileits-map">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d106224.83240082047!2d150.87676655803944!3d-33.6953354022623!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b129838f39a743f%3A0x3017d681632a850!2sSydney+NSW%2C+Australia!5e0!3m2!1sen!2sin!4v1476529926928" frameborder="0" style="border:0" allowfullscreen></iframe>
		</div>
		<div class="col-md-6 agileinfo-map">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d424521.98724489537!2d150.6419337943232!3d-33.77156856642666!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b129838f39a743f%3A0x3017d681632a850!2sSydney+NSW%2C+Australia!5e0!3m2!1sen!2sin!4v1476529981265" frameborder="0" style="border:0" allowfullscreen></iframe>
		</div>
		<div class="col-md-6 w3-agileits-map">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6697825.113257229!2d144.173733109507!3d-34.946019835412905!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b129838f39a743f%3A0x3017d681632a850!2sSydney+NSW%2C+Australia!5e0!3m2!1sen!2sin!4v1476530044829" frameborder="0" style="border:0" allowfullscreen></iframe>
		</div>
		<div class="clearfix"> </div>
	</diV>
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