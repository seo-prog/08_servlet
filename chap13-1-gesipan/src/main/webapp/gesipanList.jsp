<%--
  Created by IntelliJ IDEA.
  User: 803-02
  Date: 2024-10-18
  Time: 오후 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
    <title>*^^* 게시판 *^^*</title>
    <a href="gesipan.jsp">새 게시글 작성</a>

    <h1>게시글 목록</h1>

    ${requestScope.list}

</body>
</html>
