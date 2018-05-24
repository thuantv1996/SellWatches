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
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Tabels :: w3layouts</title>
<jsp:include page="admin_header.jsp" />
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
           <jsp:include page="admin_masterpage_header.jsp" />
<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a><i class="fa fa-angle-right"></i>Tabels</li>
            </ol>
<div class="agile-grids">	
				<!-- tables -->
				
				<div class="agile-tables">
					<div class="w3l-table-info">
					  <h2>Basic Implementation</h2>
					    <table id="table">
						<thead>
						  <tr>
							<th>Name</th>
							<th>Age</th>
							<th>Gender</th>
							<th>Height</th>
							<th>Province</th>
							<th>Sport</th>
						  </tr>
						</thead>
						<tbody>
						  <tr>
							<td>Jill Smith</td>
							<td>25</td>
							<td>Female</td>
							<td>5'4</td>
							<td>British Columbia</td>
							<td>Volleyball</td>
						  </tr>
						  <tr>
							<td>John Stone</td>
							<td>30</td>
							<td>Male</td>
							<td>5'9</td>
							<td>Ontario</td>
							<td>Badminton</td>
						  </tr>
						  <tr>
							<td>Jane Strip</td>
							<td>29</td>
							<td>Female</td>
							<td>5'6</td>
							<td>Manitoba</td>
							<td>Hockey</td>
						  </tr>
						  <tr>
							<td>Gary Mountain</td>
							<td>21</td>
							<td>Male</td>
							<td>5'8</td>
							<td>Alberta</td>
							<td>Curling</td>
						  </tr>
						  <tr>
							<td>James Camera</td>
							<td>31</td>
							<td>Male</td>
							<td>6'1</td>
							<td>British Columbia</td>
							<td>Hiking</td>
						  </tr>
						</tbody>
					  </table>
					</div>
				  <code class="js">
					$('#table').basictable();
				  </code>
		
				  <h3>Modifying Breakpoint</h3>
				  <table id="table-breakpoint">
					<thead>
					  <tr>
						<th>Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Height</th>
						<th>Province</th>
						<th>Sport</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
						<td>Jill Smith</td>
						<td>25</td>
						<td>Female</td>
						<td>5'4</td>
						<td>British Columbia</td>
						<td>Volleyball</td>
					  </tr>
					  <tr>
						<td>John Stone</td>
						<td>30</td>
						<td>Male</td>
						<td>5'9</td>
						<td>Ontario</td>
						<td>Badminton</td>
					  </tr>
					  <tr>
						<td>Jane Strip</td>
						<td>29</td>
						<td>Female</td>
						<td>5'6</td>
						<td>Manitoba</td>
						<td>Hockey</td>
					  </tr>
					  <tr>
						<td>Gary Mountain</td>
						<td>21</td>
						<td>Male</td>
						<td>5'8</td>
						<td>Alberta</td>
						<td>Curling</td>
					  </tr>
					  <tr>
						<td>James Camera</td>
						<td>31</td>
						<td>Male</td>
						<td>6'1</td>
						<td>British Columbia</td>
						<td>Hiking</td>
					  </tr>
					</tbody>
				  </table>

				  <code class="js">
					$('#table-breakpoint').basictable({<br>
					&nbsp;&nbsp;&nbsp;&nbsp;breakpoint: 768,<br>
					});
				  </code>
			<!---728x90--->
				  <h3>Force Responsive Off</h3>

				 
				  <table id="table-force-off">
					<thead>
					  <tr>
						<th>Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Height</th>
						<th>Province</th>
						<th>Sport</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
						<td>Jill Smith</td>
						<td>25</td>
						<td>Female</td>
						<td>5'4</td>
						<td>British Columbia</td>
						<td>Volleyball</td>
					  </tr>
					  <tr>
						<td>John Stone</td>
						<td>30</td>
						<td>Male</td>
						<td>5'9</td>
						<td>Ontario</td>
						<td>Badminton</td>
					  </tr>
					  <tr>
						<td>Jane Strip</td>
						<td>29</td>
						<td>Female</td>
						<td>5'6</td>
						<td>Manitoba</td>
						<td>Hockey</td>
					  </tr>
					  <tr>
						<td>Gary Mountain</td>
						<td>21</td>
						<td>Male</td>
						<td>5'8</td>
						<td>Alberta</td>
						<td>Curling</td>
					  </tr>
					  <tr>
						<td>James Camera</td>
						<td>31</td>
						<td>Male</td>
						<td>6'1</td>
						<td>British Columbia</td>
						<td>Hiking</td>
					  </tr>
					</tbody>
				  </table>

				  <code class="js">
					$('#table-force-off').basictable({<br>
					&nbsp;&nbsp;&nbsp;&nbsp;forceResponsive: false,<br>
					});
				  </code>

				  <h3>Max Height</h3>
				 <table id="table-max-height" class="max-height">
					<thead>
					  <tr>
						<th>Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Height</th>
						<th>Province</th>
						<th>Sport</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
						<td>Jill Smith</td>
						<td>25</td>
						<td>Female</td>
						<td>5'4</td>
						<td>British Columbia</td>
						<td>Volleyball</td>
					  </tr>
					  <tr>
						<td>John Stone</td>
						<td>30</td>
						<td>Male</td>
						<td>5'9</td>
						<td>Ontario</td>
						<td>Badminton</td>
					  </tr>
					  <tr>
						<td>Jane Strip</td>
						<td>29</td>
						<td>Female</td>
						<td>5'6</td>
						<td>Manitoba</td>
						<td>Hockey</td>
					  </tr>
					  <tr>
						<td>Gary Mountain</td>
						<td>21</td>
						<td>Male</td>
						<td>5'8</td>
						<td>Alberta</td>
						<td>Curling</td>
					  </tr>
					  <tr>
						<td>James Camera</td>
						<td>31</td>
						<td>Male</td>
						<td>6'1</td>
						<td>British Columbia</td>
						<td>Hiking</td>
					  </tr>
					</tbody>
				  </table>

				  <code class="js">
					$('#table-max-height').basictable({<br>
					&nbsp;&nbsp;&nbsp;&nbsp;tableWrapper: true<br>
					});
				  </code>

				  <h3>Use Media Query Over JS Resize</h3>
				 
				  <table id="table-no-resize">
					<thead>
					  <tr>
						<th>Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Height</th>
						<th>Province</th>
						<th>Sport</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
						<td>Jill Smith</td>
						<td>25</td>
						<td>Female</td>
						<td>5'4</td>
						<td>British Columbia</td>
						<td>Volleyball</td>
					  </tr>
					  <tr>
						<td>John Stone</td>
						<td>30</td>
						<td>Male</td>
						<td>5'9</td>
						<td>Ontario</td>
						<td>Badminton</td>
					  </tr>
					  <tr>
						<td>Jane Strip</td>
						<td>29</td>
						<td>Female</td>
						<td>5'6</td>
						<td>Manitoba</td>
						<td>Hockey</td>
					  </tr>
					  <tr>
						<td>Gary Mountain</td>
						<td>21</td>
						<td>Male</td>
						<td>5'8</td>
						<td>Alberta</td>
						<td>Curling</td>
					  </tr>
					  <tr>
						<td>James Camera</td>
						<td>31</td>
						<td>Male</td>
						<td>6'1</td>
						<td>British Columbia</td>
						<td>Hiking</td>
					  </tr>
					</tbody>
				  </table>

				  <code class="css">
					@media only screen and (max-width: 568px) {<br>
					&nbsp;&nbsp;#table-no-resize thead {<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;display: none;<br>
					&nbsp;&nbsp;}<br><br>

					&nbsp;&nbsp;#table-no-resize tbody td {<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;border: none !important;<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;display: block;<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;vertical-align: top;<br>
					&nbsp;&nbsp;}<br><br>

					&nbsp;&nbsp;#table-no-resize tbody td:before {<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;content: attr(data-th) ": ";<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;display: inline-block;<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;font-weight: bold;<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;width: 6.5em;<br>
					&nbsp;&nbsp;}<br><br>

					&nbsp;&nbsp;#table-no-resize tbody td.bt-hide {<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;display: none;<br>
					&nbsp;&nbsp;}<br>
					}
				  </code>

				  <code class="js">
					$('#table-no-resize').basictable({<br>
					&nbsp;&nbsp;&nbsp;&nbsp;noResize: true,<br>
					});
				  </code>

				  <h3>Two Axis Styling</h3>
				  <table id="table-two-axis" class="two-axis">
					<thead>
					  <tr>
						<th>Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Height</th>
						<th>Province</th>
						<th>Sport</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
						<td>Jill Smith</td>
						<td>25</td>
						<td>Female</td>
						<td>5'4</td>
						<td>British Columbia</td>
						<td>Volleyball</td>
					  </tr>
					  <tr>
						<td>John Stone</td>
						<td>30</td>
						<td>Male</td>
						<td>5'9</td>
						<td>Ontario</td>
						<td>Badminton</td>
					  </tr>
					  <tr>
						<td>Jane Strip</td>
						<td>29</td>
						<td>Female</td>
						<td>5'6</td>
						<td>Manitoba</td>
						<td>Hockey</td>
					  </tr>
					  <tr>
						<td>Gary Mountain</td>
						<td>21</td>
						<td>Male</td>
						<td>5'8</td>
						<td>Alberta</td>
						<td>Curling</td>
					  </tr>
					  <tr>
						<td>James Camera</td>
						<td>31</td>
						<td>Male</td>
						<td>6'1</td>
						<td>British Columbia</td>
						<td>Hiking</td>
					  </tr>
					</tbody>
				  </table>

				  <code class="css w3agile-css">
					table.two-axis tr td:first-of-type {<br>
					&nbsp;&nbsp;&nbsp;&nbsp;background: #dff1f7;<br>
					}<br><br>

					@media only screen and (max-width: 568px) {<br>
					&nbsp;&nbsp;&nbsp;&nbsp;table.two-axis tr td:first-of-type,<br>
					&nbsp;&nbsp;&nbsp;&nbsp;table.two-axis tr:nth-of-type(2n+2) td:first-of-type,<br>
					&nbsp;&nbsp;&nbsp;&nbsp;table.two-axis tr td:first-of-type:before
					 {<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;background: #dff1f7;<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;color: #ffffff;<br>
					&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>

					&nbsp;&nbsp;&nbsp;&nbsp;table.two-axis tr td:first-of-type {<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;border-bottom: 1px solid #e4ebeb;<br>
					&nbsp;&nbsp;&nbsp;&nbsp;}<br>
					}
				  </code>

				</div>
				<!-- //tables -->
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