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
    <span>${error}</span>
    <a href="settlement">薪资结算</a>
    <a href="">查看员工复议单</a>
    <a href=""></a>
    <a href=""></a>
</div>
<a href="skipAdministratorPages">返回</a>
</body>
</html>
