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
    <span>${rp}</span>
    <a href="skipAddRewardPunishment">添加奖惩信息</a>
    <a href="skipAllRewardPunishment">查看奖惩信息</a>
</div>
<a href="skipAdministratorPages">返回</a>
</body>
</html>
