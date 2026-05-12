<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>UserDTO의 정보</h3>
아이디:  ${userDTO.id}<br>
이름:  ${userDTO.name}<br>
나이:  ${userDTO.age}<br>
주소:  ${userDTO.addr}<br>

msg: ${msg }<br>
hobbies: ${hobbyList }<br>

<hr>
<h3>UserDTO의 정보 - @ModelAttribute("dto")</h3>
아이디:  ${dto.id}<br>
이름:  ${dto.name}<br>
나이:  ${dto.age}<br>
주소:  ${dto.addr}<br>

</body>
</html>