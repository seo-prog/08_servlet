<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--제일 처음에 보여줄 화면 --%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>라이프 사이클 테스트</h1>
<br/>
<%--두가지 방식이 있다. xml 과 annotation 방식 ! annotation 방식이 최신방식 이므로 많이 쓰일 것 !--%>
<%--중간에는 a 태그로 가운데는 찍힐글씨 !--%>
<a href="xml-lifecycle">라이프 사이클 테스트(xml)</a>
<br/>
<a href="annotation-lifecycle">라이프 사이클 테스트(annotation)</a>
</body>
</html>