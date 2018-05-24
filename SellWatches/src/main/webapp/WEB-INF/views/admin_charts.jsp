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
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Charts :: w3layouts</title>
<jsp:include page="admin_header.jsp" />
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
             <jsp:include page="admin_masterpage_header.jsp" />
		<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a><i class="fa fa-angle-right"></i>Charts</li>
            </ol>
		<div class="w3-agile-chat">
				<div class="charts">
					<div class="col-md-4 w3layouts-char">
						<div class="charts-grids widget">
							<h4 class="title">Bar Chart Example</h4>
							<canvas id="bar"> </canvas>
						</div>
					</div>
					<div class="col-md-4 w3-char">
						<div class="charts-grids widget states-mdl">
							<h4 class="title">Line Chart Example</h4>
							<canvas id="line"> </canvas>
						</div>
					</div>
					<div class="col-md-4 w3l-char">
						<div class="charts-grids widget">
							<h4 class="title">Pie Chart Example</h4>
							<canvas id="pie"> </canvas>
						</div>
					</div>
					<div class="clearfix"> </div>
							 <script>
								var barChartData = {
									labels : ["Jan","Feb","March","April","May","June","July"],
									datasets : [
										{
											fillColor : "rgb(199, 54, 39)",
											strokeColor : "rgba(233, 78, 2, 0.9)",
											highlightFill: "#e74c3c",
											highlightStroke: "#e74c3c",
											data : [65,59,90,81,56,55,40]
										},
										{
											fillColor : "rgb(23, 136, 210)",
											strokeColor : "rgba(79, 82, 186, 0.9)",
											highlightFill: "#1b93e1",
											highlightStroke: "#1b93e1",
											data : [40,70,55,20,45,70,60]
										}
									]
									
								};
								var lineChartData = {
									labels : ["Jan","Feb","March","April","May","June","July"],
									datasets : [
										{
											fillColor : "rgb(199, 54, 39)",
											strokeColor : "#F2B33F",
											pointColor : "rgba(242, 179, 63, 1)",
											pointStrokeColor : "#fff",
											data : [70,60,72,61,75,59,80]

										},
										{
											fillColor : "rgb(23, 136, 210)",
											strokeColor : "#6164C1",
											pointColor : "rgba(97, 100, 193,1)",
											pointStrokeColor : "#9358ac",
											data : [50,65,51,67,52,64,50]

										}
									]
									
								};
								var pieData = [
										{
											value: 90,
											color:"rgb(23, 136, 210)",
											label: "Product 1"
										},
										{
											value : 50,
											color : "rgb(199, 54, 39)",
											label: "Product 2"
										},
										{
											value : 60,
											color : "rgb(155, 197, 13)",
											label: "Product 3"
										},
										{
											value : 40,
											color : "rgb(135, 66, 165)",
											label: "Product 4"
										}
										
									];
								
							new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);
							new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
							new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);
							
							</script>
							
				</div>
		<div class="hight-chat">
					<div class="col-md-6 w3ls-high">
						<div class="hightchat-grid">
							<script type="text/javascript">
							  // Generate data
							  
							  var data = [];
							  
							  var time = new Date('Dec 1, 2013 12:00').valueOf();
							  
							  var h = Math.floor(Math.random() * 100);
							  var l = h - Math.floor(Math.random() * 20);
							  var o = h - Math.floor(Math.random() * (h - l));
							  var c = h - Math.floor(Math.random() * (h - l));

							  var v = Math.floor(Math.random() * 1000);
							  
							  for (var i = 0; i < 30; i++) {
								data.push([time, o, h, l, c, v]);
								h += Math.floor(Math.random() * 10 - 5);
								l = h - Math.floor(Math.random() * 20);
								o = h - Math.floor(Math.random() * (h - l));
								c = h - Math.floor(Math.random() * (h - l));
								v += Math.floor(Math.random() * 100 - 50);
								time += 30 * 60000; // Add 30 minutes
							  }
							</script>
							<h2>Points</h2>
							<div id="example-1"></div>
						   <script type="text/javascript">
							  $(function() {
								$('#example-1').jqCandlestick({
								  data: data,
								  theme: 'light',
								  series: [{
								  }],
								});
							  });
							</script>
							<script type="text/javascript">
							var _gaq = _gaq || [];
							  _gaq.push(['_setAccount', 'UA-36251023-1']);
							  _gaq.push(['_setDomainName', 'jqueryscript.net']);
							  _gaq.push(['_trackPageview']);

							  (function() {
								var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
								ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
								var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
							  })();
							</script>
						</div>
					</div>
					<div class="col-md-6 agileits-high"> 
						<div class="hightchat-grid1">  
							<h3>Multiple y-axis</h3>
							<div id="example-6"></div>
							<script type="text/javascript">
							  $(function() {
								$('#example-6').jqCandlestick({
								  data: data,
								  theme: 'light',
								  series: [{
									type: 'candlestick',
									color: '#00C',
								  }],
								});
							  });
							</script>
						</div>
					</div>
					<div class="clearfix"></div>
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
<!-- candlestick -->
		<script type="text/javascript" src="<c:url value="/resources/admin_js/jquery.jqcandlestick.min.js" />"></script>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/admin_css/jqcandlestick.css" />" />
		<!-- //candlestick -->
</body>
</html>