<%--성공 했을 떄 보여줄 jsp--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>
<%--requestScope 로 값을 편하게 가지고 올 수 있다. --%>
<%-- selectEmp DTO 에서 필드 하나씩 꺼내오는거라 보면 된다.  --%>
    사원 번호 : ${requestScope.selectEmp.empId} <br/>
    사원 명 : ${requestScope.selectEmp.empName}<br/>
    부서 코드 : ${requestScope.selectEmp.deptCode}<br/>
    직급 코드 : ${requestScope.selectEmp.jobCode}<br/>
    급여 : ${requestScope.selectEmp.salary}

</body>
</html>
