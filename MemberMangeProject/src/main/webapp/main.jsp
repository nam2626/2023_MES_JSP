<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		margin:30px auto;
	}
	td, th{
		padding: 10px;
		font-size: 1.3em;
		border : 1px solid black;
		text-align: center;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	
</script>
</head>
<body>
	<!-- header.jsp include -->
	<jsp:include page="template/header.jsp"></jsp:include>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody>
			<!-- 
				회원 아이디 클릭시 detail?id=아이디값   
				회원정보 수정 페이지로 이동(member_update_view.jsp)
				해당 페이지 폼에 회원 정보를 미리 셋팅
			
			 -->
			<c:forEach items="${list }" var="m">
				<tr>
					<td><a href="detail?id=${m.memberId}">${ m.memberId}</a></td>
					<td>${ m.name}</td>
					<td>${ m.age}</td>
					<td>${ m.gender}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>















