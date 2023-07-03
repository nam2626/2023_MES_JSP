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
	<p>여러개의 조건문이 필요할때</p>
	<c:choose>
		<c:when test="${age >= 20 && age < 30 }">
			<p>20대입니다.</p>
		</c:when>	
		<c:when test="${age >= 30 and age < 40 }">
			<p>30대입니다.</p>
		</c:when>	
		<c:otherwise>
			<p>40대입니다.</p>
		</c:otherwise>
	</c:choose>
	<p>반복문 - 시작값, 종료값, 증감값을 속성값으로 설정해서 반복</p>
	<ul>
		<c:forEach begin="1" end="10" var="i">
			<li>${i } - 번째 생성</li>
		</c:forEach>
	</ul>
	<ul>
		<!-- step 속성은 증감값  -->
		<c:forEach begin="1" end="10" var="i" step="2">
			<li>${i } - 번째 생성</li>
		</c:forEach>
	</ul>
	<!-- 리스트나 배열 같은 객체 있는 데이터를 전부 조회 -->
	<ul>
		<c:forEach items="${requestScope.list }" var="m" varStatus="s">
			<li>${m.toString() } - ${s.index }</li>
		</c:forEach>
	</ul>
</body>
</html>














