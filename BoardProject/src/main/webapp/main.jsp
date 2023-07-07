<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	section{
		width: 1200px;
		margin:0 auto;
	}
	section table{
		width: 90%;
		border-collapse: collapse;
	}
	section table td,section table th{
		border:1px solid black;
		text-align: center;
		padding:10px 0px;
	}
	section tfoot{
		font-size: 0px;
	}
	section tfoot a:link,section tfoot a:visited{
		display: inline-block;
		padding:0px 10px;
		text-decoration: none;
		color:black;
		font-size: 16px !important;
	}
	
	.current_page{
		display: inline-block;
		padding:0px 10px;
		font-size: 16px !important;
		color:red;
		font-weight: bold;
	}
	tfoot > tr > td{
		position: relative;
	}
	.btn_write{
		display: inline-block;
		padding:0px 20px !important;
		position: absolute;
		right:0px;
	}
</style>
</head>
<body>
		<jsp:include page="template/header.jsp"></jsp:include>
		<section>
			<table>
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>직네임</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>좋아요</th>
						<th>싫어요</th>
					</tr>
				</thead>
				<tbody>
				<!-- 게시글 목록  -->
				</tbody>
				<tfoot>
					<tr>
					<td colspan="7">
					</td>
					</tr>
				</tfoot>
			</table>		
		</section>
</body>
</html>



