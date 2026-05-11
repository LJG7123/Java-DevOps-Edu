<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>성공 페이지입니다</h1>
결과1 : <%=request.getAttribute("hobbies") %> <br>
결과2 : ${ requestScope.hobbies } <br> <!-- 표현언어 방식, jsp 코드를 좀 더 간결하게 -->
결과3 : ${ hobbies } <br> <!-- requestScope 생략가능 -->
</body>
</html>