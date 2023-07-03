<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el 태그</h2>
	<p>request 영역에 저장된 내용은 requestScope를 사용해서 뽑음</p>
	<p>age : ${requestScope.age }</p>
	<p>session 영역에 저장된 내용은 sessionScope를 사용해서 뽑음</p>
	<p>msg : ${sessionScope.msg }</p>
	<p>session에 저장된 객체 dto를 뽑음</p>
	<p>${sessionScope.dto.id },${sessionScope.dto.passwd },${sessionScope.dto.name },
	${sessionScope.dto.nick },${sessionScope.dto.gradeNo }</p>
	<p>${sessionScope.dto.toString() }</p>
	<h2>jstl 테스트</h2>
	<!-- set : 변수를 만들어서 데이터를 초기화 -->
	<p><c:set var="tnum" value="10000" /></p>
	<!-- out : 해당 변수/데이터를 출력, requestScope 생략이 가능-->
	<p><c:out value="${tnum }" />${tnum },${age }</p>
	<!-- 관계연산자 결과 -->
	<p>${age == 40 }</p>
	<!-- if문 : test속성이 조건식(el로 표현), else, else if가 없음 -->
	<p>if문</p>
	<c:if test="${requestScope.age >= 20 }">
		<p>성인입니다.</p>
	</c:if>
	<c:if test="${requestScope.age < 20 }">
		<p>미성년자입니다.</p>
	</c:if>
</body>
</html>














