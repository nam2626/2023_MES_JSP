<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등급 관리 페이지</title>
<style>
	h2{
		width:1200px;
		margin:0 auto;
		text-align: center;;
	}
	.container{
		width:1200px;
		margin : 0 auto;
		display:flex;
	}
	.manage_container, .register_container{
		padding:20px;
	}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	
</script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<h2>회원 등급 관리 페이지</h2>
	<div class="container">
		<div class="manage_container">
			<h3>등급 관리</h3>
			<hr>
			<p>
				<input type="text" id="search" placeholder="검색할 등급명 일부">
				<button type="button">검색</button>
			</p>
			<div class="content">
				<!-- 회원 등급 목록 -->
			</div>
		</div>
		<div class="register_container">	
			<h3>등급 추가 폼</h3>
			<hr>
			<form id="register_grade">
				<input type="text" name="grade_no" placeholder="등급번호">
				<input type="text" name="grade_name" placeholder="등급명">
				<button type="button">등급 추가</button>
			</form>
		</div>
	</div>	
</body>
</html>












