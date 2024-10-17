
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>

    <form action="register" method="post">
    <table>
    <input type='text' name='userID' placeholder="아이디" required/>
    <input type='password' name='password' placeholder="비밀번호" required/>
        <input type='text' name='Email' placeholder="이메일" required/>
    <input type='submit' value='가입하기'>

</table>
    </form>

<a href="login.jsp">로그인 하기</a>
</body>
</html>


<%--setContentType.append("<form action='/first/login' method='post'>\n")--%>
<%--.append("<!doctype html>\n")--%>
<%--.append("<html>\n")--%>
<%--.append("<head>\n")--%>
<%--.append(" 회원가입\n")--%>
<%--.append("</head>\n")--%>
<%--.append("<body>\n")--%>
<%--.append("<input type='text' name='userID' required/><br>")--%>
<%--.append("<input type='password' name='password' required/><br>")--%>
<%--.append("<input type='text' name='Email' required/><br>")--%>
<%--.append("<input type='submit' value='가입하기'>")--%>
<%--.append("</form>\n")--%>
<%--.append("</body>\n")--%>
<%--.append("</html>\n");--%>