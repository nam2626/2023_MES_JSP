<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 결과</h2>
	<%
		String id = (String)session.getAttribute("id");
		if(id != null){
	%>
			<!-- 로그인 했을 때에만 출력하는 부분 -->
			<p><%=id %>님이 로그인 하셨습니다.</p>
			<a href="logout">로그아웃</a>
	<%
		}else{
			//한글 처리 필요
			//로그인 안했을때는 아래 두개 중 하나만 처리
			//로그인 안했을때 출력하는 부분 - 1
			//response.setContentType("text/html; charset=UTF-8");
			//response.getWriter().append("<script>alert('로그인 실패 아이디 비밀번호 확인하세요');location.href = 'login.jsp';</script>");
	%>
		<!-- 로그인 안했을때에만 출력하는 부분 - 2  -->
		<script>
			alert("로그인 실패 아이디 비밀번호를 확인하세요");
			//location.href = 'login.jsp';
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>






