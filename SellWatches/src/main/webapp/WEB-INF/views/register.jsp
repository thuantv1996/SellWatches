<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springForm" %>
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
	<title>Register</title>
	<jsp:include page="head.jsp" />		
</head>
<body> 
	<jsp:include page="masterpage_header.jsp" />
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="index.html">Home</a></li>
					<li class="active">Register</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--register-starts-->
	<div class="register">
		<div class="container">
			<springForm:form method="POST" action="Register" modelAttribute="registerViewModel">
				<c:if test='${checkRegister == "Tạo tài khoản thành công"}'>
					<div class="alert alert-success" role="alert"> 
	                    <strong>Chúc mừng bạn!</strong> đã đăng ký thành công.
	                    <br />Vui lòng click <a href="<c:url value="/Login" />">vào đây</a> để đăng nhập.
	                </div>
				</c:if>
				<div class="register-top heading">
					<h2>REGISTER</h2>
				</div>
				<div class="register-main">
					<div style="position: relative; padding-right: 15px; padding-left: 15px">
						<span style="color:#f00">
                            ${isExistAccount}
                        </span>
						<span style="color:#f00">
                            ${isValidPassWord}
                        </span>
                        <springForm:errors path="email" cssStyle="color:#f00"/>
                        <springForm:errors path="userName" cssStyle="color:#f00"/> <br />
                        <springForm:errors path="passWord" cssStyle="color:#f00"/>
                	</div>
					<div class="col-md-6 account-left">
						<input name="firstName" placeholder="First name" type="text" tabindex="1" required>
						<input name="lastName" placeholder="Last name" type="text" tabindex="2" required>
						<input name="address" placeholder="Address" type="text" tabindex="3" required>  
						<input name="email" placeholder="Email address" type="text" tabindex="4" required>
						<input name="numberPhone" placeholder="Mobile" type="text" tabindex="5" required>
						<ul>
							<li><label class="radio left"><input name="sex" type="radio" name="radio" checked="" value="Nam"><i></i>Male</label></li>
							<li><label class="radio"><input name="sex" type="radio" name="radio" value="Nữ"><i></i>Female</label></li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<div class="col-md-6 account-left">
						<input name="userName" placeholder="Account" type="text" tabindex="6" required>   
						<input id="inPassWord" name="passWord" placeholder="Password" type="password" tabindex="7" required>
						<input id="rePassWord" placeholder="Retype password" type="password" tabindex="8" required>
						<br />
						<span id="LoiPassWord" style="color: red; font-family: 'Lato-Regular'"></span>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="address submit">
					<input id="btnSubmit" type="submit" value="Submit">
				</div>
			</springForm:form>
		</div>
	</div>
	<!--register-end-->
	<jsp:include page="masterpage_footer.jsp" />
</body>
	<!--Script kiểm tra ô nhập lại mật khẩu phải trùng với ô trên-->
	<script type="text/javascript">
	    $('#btnSubmit').click(function () {
	        var loi = 0;
	        if($('#inPassWord').val() != $('#rePassWord').val())
	        {
	            $('#LoiPassWord').text('Mật khẩu không khớp nhau !');
	            loi++;
	        }
	        else {
	            $('#LoiPassWord').text('');
	        }
	        if(loi != 0)
	        {
	            return false;
	        }
	        return true;
	    });
	</script>
</html>