<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
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
    <p>欢迎 <span style="color: green">${sessionScope.user.name}</span> 进入人力资源网站</p>
    <a href="">招聘信息</a>
    <a href="">填写简历</a>
    <a href="">查看简历</a>
    <a href="">查看面试邀请</a>
    <a href="">注册账号</a>
    <a href="">登陆</a>
</div>
</body>
</html>
