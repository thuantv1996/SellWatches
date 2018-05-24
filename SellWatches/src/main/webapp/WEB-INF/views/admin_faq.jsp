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
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Faq :: w3layouts</title>
<jsp:include page="admin_header.jsp" />
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
             <jsp:include page="admin_masterpage_header.jsp" />
			<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a><i class="fa fa-angle-right"></i>Short Codes <i class="fa fa-angle-right"></i>Faq</li>
            </ol>
<!-- faq -->
				
				
				
				<div class="asked">
					<div class="questions">
						<h2>1.What is Lorem Ipsum?</h2>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
					</div>
					 <div class="questions">
						<h5>2.What is Lorem Ipsum dummy text ever since the 1500s?</h5>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
					 </div>	
					
					  <div class="questions">
						<h5>3.What is Duis laoreet, erat quis gravida porttitor odio felis ornare dui?</h5>
						<p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam semper elit risus, nec suscipit tellus tincidunt quis. Fusce non auctor enim. Suspendisse sit amet erat mollis, suscipit nisl sed, condimentum turpis. Curabitur faucibus, nisl ut aliquam porta, massa tortor tristique dolor, eget porttitor velit ligula vel eros. Sed egestas aliquet tellus. Nulla ac luctus urna. Pellentesque feugiat eros quis nibh consectetur, eget dapibus magna egestas. Phasellus non efficitur metus.</p>
					 </div>	
					
					  <div class="questions">
						<h5>4.What is Quisque sollicitudin diam vel mauris volutpat viverra Proin ac imperdiet libero?</h5>
						<p>Proin dignissim mi sit amet tincidunt varius. Quisque molestie fermentum dignissim. Sed in urna eget tortor congue tempus. Vestibulum gravida, erat in eleifend ultricies, felis lorem dictum nulla, ut tincidunt neque libero et nibh. Nullam at eros eu ligula auctor interdum a eget lorem. Praesent molestie eros vitae felis efficitur, at finibus sem molestie. Ut sit amet nisi at nunc pulvinar dapibus. Sed non neque et tortor finibus mattis. Mauris sit amet consectetur eros. Sed et ex posuere, vulputate dolor vel, pulvinar felis. </p>
					 </div>	
					  <div class="questions">
						<h5>5.What is Nam semper elit risus, nec suscipit tellus tincidunt quis?</h5>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
					 </div>	
					  <div class="questions">
						<h5>6.What is Quisque molestie fermentum dignissim?</h5>
						<p>Sed eget nunc ex. Donec erat est, dapibus ac massa in, laoreet sagittis eros. Aliquam eget arcu feugiat leo elementum tristique. Praesent facilisis aliquam lorem sed pharetra. Donec scelerisque ipsum vel tincidunt gravida. Aliquam erat volutpat. Etiam mattis rhoncus massa, quis semper purus ornare id. Quisque sit amet mattis ipsum, in porttitor massa. Nullam tincidunt mi vel enim volutpat, a elementum libero imperdiet. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean tincidunt eros eu nisl consequat facilisis. Maecenas ac accumsan elit, sit amet gravida nulla.</p>
					 </div>	
					  <div class="questions">
						<h5>7.What is Vestibulum ante ipsum primis in faucibus orci luctus et?</h5>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
					 </div>				    

				</div>
				<!-- //faq -->
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