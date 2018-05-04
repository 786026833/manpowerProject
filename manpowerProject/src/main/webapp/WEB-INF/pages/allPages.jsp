<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
<div>
    <a href="queryAllDepartment?eId=${employee.eId}">查看部门</a>
    <a href="queryAllPos?eId=${employee.eId}">查看职位</a>
    <a href="queryAllemployee3?eId=${employee.eId}">查看员工</a>
    <a href="skipEmployeePages?eId=${employee.eId}">返回</a>
</div>
</body>
</html>
