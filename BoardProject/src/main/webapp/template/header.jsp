<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
    	nav{
		width: 1200px;
		margin:0 auto;
		}
		nav > ul{
			display: flex;
			flex-direction: row;
			justify-content: center;
			list-style-type: none;
		}
		nav > ul > li{
			width: 200px;
		}
    </style>
  	<!-- 
  			홈 - 게시판 : main.do
  			회원관리 : memberMain.do
  			로그아웃 : logout.do
  	 -->
	<!-- 회원등급이 0이면 관리자이므로 홈 게시판 회원관리 로그아웃 메뉴를 출력   -->
	<!-- 회원등급이 0아니면 사용자이므로 홈 게시판 로그아웃 메뉴를 출력   -->
	<nav>
		<ul>
			<li><a href="main.do">홈</a></li>
			<li><a href="main.do">게시판</a></li>
			<c:if test="${sessionScope.user.gradeNo == 0 }">
				<li><a href="memberMain.do">회원관리</a></li>
			</c:if>
			<li><a href="logout.do">로그아웃</a></li>
		</ul>
	</nav>
	
	
	
	
	
	
	
	
	
	
	