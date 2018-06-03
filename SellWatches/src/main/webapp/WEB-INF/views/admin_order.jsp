<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Order</title>
<jsp:include page="admin_header.jsp" />
<link rel="stylesheet" href="<c:url value="/resources/admin_css/custom-admin.css" />" type='text/css' />
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
              <jsp:include page="admin_masterpage_header.jsp" />
		<ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="<c:url value="/admin/home" />">Home</a><i class="fa fa-angle-right"></i>Order</li>
        </ol>
		<!-- phần hóa đơn -->
		<div>
			<a class="btn-hienthithemhoadon btn btn-success">Thêm hóa đơn</a>
			<a class="btn-hienthidanhsachhoadon btn btn-success">Hiển thị danh sách hóa đơn</a>
		</div>
		
		<div class="themhoadon anbutton">
			<div class="page-title form-style">
				<div class="titleHoaDon">
					<span class="title">Hóa đơn</span>
			   		<div class="description">Quản lý nội dung liên tới hóa đơn</div>
				</div>
			   	<table cellspacing="10" cellpadding="10">
			   		<tr>
			   			<th>
			   				<label for="ip_chudonhang">Chủ đơn hàng</label>
		    				<input type="text" class="form-control" id="ip_chudonhang" placeholder="Nhập tên chủ đơn hàng" />
			   			</th>
		
			   			<th>
			   				<label for="ip_sodtdonhang">Số điện thoại</label>
		    				<input type="number" class="form-control" id="ip_sodtdonhang" placeholder="Nhập số điện thoại" />
			   			</th>
			   		</tr>
		
			   		<tr>
			   			<th>
			   				<label for="ip_diachi">Địa chỉ</label>
		    				<input type="text" class="form-control" id="ip_diachi" placeholder="Nhập địa chỉ" />
			   			</th>
		
			   			<th>
			   				<label for="ip_tongtien">Tổng tiền</label>
		    				<input type="text" class="form-control" id="ip_tongtien" placeholder="Tổng tiền" />
			   			</th>
			   		</tr>
		
			   			<tr>
			   			<th>
			   				<label for="ip_ngaymua">Ngày đặt</label>
		    				<input type="text" class="form-control" id="ip_ngaymua" placeholder="Nhập ngày mua" />
			   			</th>
		
			   			<th>
			   				<label for="ip_ngaygiao">Ngày giao</label>
		    				<input type="text" class="form-control" id="ip_ngaygiao" placeholder="Nhập ngày giao" />
			   			</th>
			   		</tr>
		
			   		<tr>
			   			<th>
			   				<label for="sl_tinhtranghoadon">Trạng thái</label>
			   				<select id="sl_tinhtranghoadon">
			   					<optgroup label="Tình trạng">
			   						<option value="chờ kiểm duyệt">chờ kiểm duyệt</option>
			   						<option value="đã hủy">đã hủy</option>
			   						<option value="đang giao hàng">đang giao hàng</option>
			   						<option value="hoàn thành">hoàn thành</option>
			   					</optgroup>
			   				</select>
			   			</th>
			   		</tr>
		
			   		<tr>
			   			<th colspan="2">
			   				<span>Chi tiết hóa đơn</span>
			   				<div>
			   						<select id="sl_tenspchitiethd">
					   					<c:forEach var="products" items="${listProducts}">
					   						<option value="${products.getId()}">${products.getNameProduct()}</option>
					   					</c:forEach>
					   				</select>
		
					   				<input id="ip_soluongsanphamhd" type="number" min="1" value="1"  />
		
					   				<a class="btn btn-default btn-themchitiethoadon">Thêm vào chi tiết hóa đơn</a>
			   				</div>
		
			   				<div id="khungchitiethoadon">
			   					<table>
			   						<tbody>
		
			   						</tbody>
			   					</table>
			   				</div>
			   			</th>
			   		</tr>   		
			        
			   	</table>
			   	
			   	<div style="background-color: white; margin: 10px; padding-bottom: 20px">
			   		<input type="button" class="btn btn-success" id="btn-themhoadon" value="Đồng ý">
	        		<input type="button" class="btn btn-success anbutton" id="btn-dongycapnhathoadon" value="Cập nhật">
			   	</div>
		
		        <div class="thongbaoloi"></div>
		
		    </div>
		</div>

		<div class="hienthihoadon">
			<div class="card">
				<div class="col-right">
					<table class="timkiem">
						<tr>
							<td style="padding: 10px 0px"><input type="text" class="form-control" id="txt-timkiemsanpham" placeholder="Nhập tên hóa đơn cần tìm"/></td>
							<td style="padding: 10px 0px"><button id="btn-timkiemsanpham" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button></td>
						</tr>
					</table>
				</div>
				<div class="col-left">
					<h2>Danh sách hóa đơn</h2>
				</div>
				 
				<table id="table">
						<thead>
						  <tr>
							<th>Chủ đơn hàng</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ</th>
							<th>Tình trạng</th>
							<th>Ngày đặt</th>
							<th>Ngày giao</th>
							<th>Tổng tiền</th>
						  </tr>
						</thead>
						<tbody>
							<c:forEach var="value" items="${listOrders}">
								<tr>
									<td data-tennguoinhan="${value.getCustomer().getName()}">${value.getCustomer().getName()}</td>
									<td data-sodt="${value.getNumberPhone()}">${value.getNumberPhone()}</td>
									<td data-diachi="${value.getDeliveryAddress()}">${value.getDeliveryAddress()}</td>
									<td data-tinhtrang="${value.getStatus()}">${value.getStatus()}</td>
									<td data-ngaymua="${value.getOrderDay()}">${value.getOrderDay()}</td>
									<td data-ngaygiao="${value.getDeliveryDay()}">${value.getDeliveryDay()}</td>
									<td data-tongtien="${value.getAmount()}"><fmt:formatNumber type='number' pattern='###,###' value="${value.getAmount()}" /> VNĐ</td>
									<td data-id="${value.getId()}" data-idCus="${value.getCustomer().getId()}"><a class="btn btn-success btn-capnhathoadon">Cập nhật</a></td>
								</tr>
							</c:forEach>
						</tbody>
					  </table>
		
				<div id="phantranghoadon" data-tongsotrang="${totalPage}">
		
				</div>
				
			</div>
		</div>
		
		
		<!-- //hết phần hóa đơn -->
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
<!-- calendar -->
	<script type="text/javascript" src="<c:url value="/resources/admin_js/monthly.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/admin_js/jquery.bootpag.js" />"></script>
	<script type="text/javascript">
		$(window).load( function() {

			$('#mycalendar').monthly({
				mode: 'event',
				
			});

			$('#mycalendar2').monthly({
				mode: 'picker',
				target: '#mytarget',
				setWidth: '250px',
				startHidden: true,
				showTrigger: '#mytarget',
				stylePast: true,
				disablePast: true
			});

		switch(window.location.protocol) {
		case 'http:':
		case 'https:':
		// running on a server, should be good.
		break;
		case 'file:':
		alert('Just a heads-up, events will not work when run locally.');
		}

		});
	</script>
	<script type="text/javascript">
	
		//Xử lý khi đồng ý cập nhập hóa đơn
		$("#btn-dongycapnhathoadon").click(function(){
			mahd = $(this).attr("data-id");
			tennguoinhan = $("#ip_chudonhang").val();
			sodt = $("#ip_sodtdonhang").val();
			diachi = $("#ip_diachi").val();
			ngaymua = $("#ip_ngaymua").val();
			ngaygiao = $("#ip_ngaygiao").val();
			tinhtrang = $("#sl_tinhtranghoadon").val();
	
			var mangmasp = [];
			var mangtensp = [];
			$("input[name='mangsanpham[]']").each(function(){
				var value = $.trim($(this).attr("data-masp"));
				var tensp = $.trim($(this).val());
				if(value.length > 0){
					mangmasp.push(value);
					mangtensp.push(tensp);
				}
	
			});
	
			var mangsoluong = [];
			$("input[name='mangsoluong[]']").each(function(){
				var value = $.trim($(this).val());
	
				if(value.length > 0){
					mangsoluong.push(value);
				}
	
			});
	
			$.ajax({
				traditional: true,
				url : "/SellWatches/Api/UpdateOrder", //đường dẫn của trang xử lý code gữi qua
				type : "GET",
				// datatype: ""
				data : {
					mahd : mahd,
					tennguoinhan: tennguoinhan,
					sodt: sodt,
					diachi: diachi,
					ngaymua: ngaymua,
					ngaygiao: ngaygiao,
					tinhtrang: tinhtrang,
					mangmasp: mangmasp,
					mangsoluong: mangsoluong,
					mangtensp: mangtensp
				},
				success:function(data){
					alert(data);
				}
			});
	
	
		});

		//Phân trang cho hóa đơn
		$('#phantranghoadon').bootpag({
		    total: $("#phantranghoadon").attr("data-tongsotrang"),
		    maxVisible: 10,
		    page: 1
		}).on("page", function(event, trang){
		    $.ajax({
				url : "/SellWatches/Api/TakeListOrderLimit", //đường dẫn của trang xử lý code gữi qua
				type : "GET",
				data : {
					pageIndex: trang
				},
				success:function(data){
					$("table#table").find("tbody").empty();
					$("table#table").find("tbody").append(data);
				}
			});
		});
	</script>
	
	
	<script type="text/javascript">
	
		//xử lý nút cập nhật hóa đơn
		$("body").delegate(".btn-capnhathoadon","click",function(){
	
			HienThiThemHoaDon();
			$("#btn-dongycapnhathoadon").removeClass("anbutton");
			$("#btn-themhoadon").addClass("anbutton");
	
			mahd = $(this).parent().attr("data-id");
			maCus = $(this).parent().attr("data-idCus");
			
			$("#btn-dongycapnhathoadon").attr("data-id",mahd);
			$("#btn-dongycapnhathoadon").attr("data-idCus",maCus);
	
			$(this).closest("tr").find("td").each(function(){
				if($(this).attr("data-tennguoinhan")){
					tennguoinhan = $(this).attr("data-tennguoinhan");
				}else if($(this).attr("data-sodt")){
					sodt = $(this).attr("data-sodt");
				}else if($(this).attr("data-diachi")){
					diachi = $(this).attr("data-diachi");
				}else if($(this).attr("data-tinhtrang")){
					tinhtrang = $(this).attr("data-tinhtrang");
				}else if($(this).attr("data-ngaymua")){
					ngaymua = $(this).attr("data-ngaymua");
				}else if($(this).attr("data-ngaygiao")){
					ngaygiao = $(this).attr("data-ngaygiao");
				}else if($(this).attr("data-tongtien")){
					tongtien = $(this).attr("data-tongtien");
				}
			});
			
			if(tinhtrang == "hoàn thành" || tinhtrang == "đã hủy") {
				$("#btn-dongycapnhathoadon").addClass("anbutton");
			}
	
			$("#ip_chudonhang").val(tennguoinhan);
			$("#ip_sodtdonhang").val(sodt);
			$("#ip_diachi").val(diachi);
			$("#ip_tongtien").val(tongtien);
			$("#ip_ngaymua").val(ngaymua);
			$("#ip_ngaygiao").val(ngaygiao);
			$("#sl_tinhtranghoadon").val(tinhtrang).trigger("change");
	
			 $.ajax({
				url : "/SellWatches/Api/LoadOrderDetail", //đường dẫn của trang xử lý code gữi qua
				type : "GET",
				// datatype: ""
				data : {
					id : mahd
				},
				success:function(data){
					$("#khungchitiethoadon").find("tbody").empty();
					$("#khungchitiethoadon").find("tbody").prepend(data);
				}
			});
	
		});
	
		//xử lý nút thêm chi tiết hóa đơn
		$('.btn-themchitiethoadon').click(function() {
			tensp = $("#sl_tenspchitiethd :selected").text();
			masp = $("#sl_tenspchitiethd").val();
			soluong = $("#ip_soluongsanphamhd").val();
			kiemtra= false;

			$("input[name='mangsoluong[]']").each(function(){
				if($(this).attr("data-masp")==masp){
					soluong = parseInt(soluong) + parseInt($(this).val());
					$(this).val(soluong);
					kiemtra = true;
				}
			});

			var content = '<tr><th>Tên sản phẩm : <input name="mangsanpham[]" data-masp="'+masp+'" value="'+tensp+'" style="margin:5px; padding:5px; width:60%"  disabled type="text"  /></th><th>Số lượng : <input data-masp="'+masp+'" disabled value="'+soluong+'" style="margin:5px; padding:5px; width:60%" name="mangsoluong[]" type="text"  /><a class="btn btn-danger btnxoachitiethoadon">Xóa</a></th></tr>';

			if(!kiemtra){
				$("#khungchitiethoadon").find("tbody").append(content);
			}
		});
		
		//xóa chi tiết hóa đơn
		$("body").delegate(".btnxoachitiethoadon","click",function(){
			$(this).closest("tr").remove();
		});
		
		$(".btn-hienthithemhoadon").click(function(){
			$("#btn-dongycapnhathoadon").addClass("anbutton");
			$("#btn-themhoadon").removeClass("anbutton");
			HienThiThemHoaDon();
		});

		$(".btn-hienthidanhsachhoadon").click(function(){
			HienThiDanhSachHoaDon();
		});

		function HienThiThemHoaDon(){
			$(".hienthihoadon").removeClass("anbutton");
			$(".hienthihoadon").fadeOut();
			$(".themhoadon").fadeIn();
		}

		function HienThiDanhSachHoaDon(){
			$(".hienthihoadon").fadeIn();
			$(".themhoadon").fadeOut();
		}
	</script>
	<!-- //calendar -->
</body>
</html>