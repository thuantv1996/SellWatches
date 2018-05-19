<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springForm" %>

<c:choose>
	<c:when test="${empty USER_SESSION}">
		<div>
			<span><a href="<c:url value="/Login" />">Sign In</a></span>
			<span><a href="<c:url value="/Register" />">Sign Up</a></span>
			<div class="clearfix"> </div>
		</div>
	</c:when>
	<c:otherwise>
		<div>
	        <span><a href="#">Welcome: ${USER_SESSION}</a></span>
	        <span><a href="<c:url value="/Logout" />">Sign Out</a></span>
	        <div class="clearfix"> </div>
	    </div>
	</c:otherwise>
</c:choose>
