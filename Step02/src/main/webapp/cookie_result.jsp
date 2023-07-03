<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>저장된 쿠키 목록</h2>
	<%
		Cookie[] cookies = request.getCookies();
	
		for(int i=0;i<cookies.length;i++){
			%>
			<%=cookies[i].getName() %> / <%=cookies[i].getValue() %> <br>
			
			<%
		}
	
	%>
	<a href="07_cookie_start.jsp">쿠키 입력 페이지 이동</a>
	<hr>
	<script type="text/javascript">
		document.write(document.cookie);
		
		//쿠키의 기본적인 패턴
        //document.cookie = 'name=값; expires=날짜; path=경로; domain=도메인';
        function setCookie(name, value, exp){
            let date = new Date();//유효기간 설정할 날짜 객체
            date.setTime(date.getTime() + exp * 24 * 60 * 60 * 1000);
            document.cookie = `${name}=${value}; expires=${date.toUTCString()}; path=/`;
        }
		
      //전체 쿠키 읽기
        function getAllCookie(){
            let allCookie = document.cookie;
            console.log(allCookie);

            //쿠키가 있는지?
            if(allCookie != ''){
                //쿠키가 있으면 쿠키를 배열로 만듬
                let cookieArray = allCookie.split('; ');

                for(let i=0;i<cookieArray.length;i++){
                    let cookie = cookieArray[i].split('=');
                    console.log(cookie[0], cookie[1]);
                }
            }else{
                console.log('쿠키가 없습니다.');
            }
        }
      getAllCookie();
	</script>	
</body>
</html>











