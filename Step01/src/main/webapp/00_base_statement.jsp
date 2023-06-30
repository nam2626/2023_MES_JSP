<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿</title>
</head>
<body>
	<!-- 선언문  -->
	<%!
		//필드
		String message = "Hello World";
	
		String getMessage(){
			return message;
		}
	%>
	<!-- 표현식, 화면(html)에 값을 출력하는 부분 -->
	선언문 필드 출력 : <%=message %><br>
	선언문 메서드 실행 결과 출력 : <%=getMessage() %><br>
	<!-- 스크립트릿, 사용자가 서버에 데이터를 전달한 것을 jsp에서 데이터를 받아서 일을 하는 부분 -->
	<!--
		파라미터명=값&파라미터명=값 <--- query string
		http://localhost:8888/Step01/00_base_statement.jsp?str=Message&num=10
	-->
	<%
		String param1 = request.getParameter("num");
		String param2 = request.getParameter("str");
	%>
	스크립트릿 테스트 : <%=param1 %><br>
	스크립트릿 테스트 : <%=param2 %><br>
</body>
</html>











