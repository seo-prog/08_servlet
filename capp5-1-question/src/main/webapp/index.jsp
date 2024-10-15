<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입 프로그램</title>
</head>
<body>
<h1>간단한 회원가입 로직 연습해보기
</h1>
<br/>
<form action="login" method="post">

<p>이름은 2글자 이상이어야 합니다..</p>
<p>전화번호는 11 자리로 입력되어야 합니다..</p>
<p>비밀번호는 8자 이상이며 비밀번호 확인과 일치해야 합니ㅣ다..</p>
<p>가입 성공시 환영합니다 @@님 / 실패 시 입력 정보를 확인 해주세요 화면에 띄우기</p>

<label>이름 : </label><input type="text" name = "name">
<br>
<label>전화번호 : </label><input type="text" name = "phonenumber">
<br>
<label>비밀번호: </label><input type="password" name = "password">
<br>
<label>비밀번호 확인: </label><input type="password" name = "passwordcheck">
<%--<a href="login">로그인하기</a>--%>

    <input type="submit" value="POST 요청">
</form>
</body>
</html>