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
    <p>欢迎游客进入人力资源网站</p>
    <a href="selectInformation?currentPage=1">招聘信息</a><br>
    <a href="skipResume?permission=2">填写简历</a><br>
    <a href="skipQueryResume?permission=2&resume=0">查看简历</a><br>
    <a href="permission=2">查看面试邀请</a><br>
    <a href="skipUserRegister">注册账号</a>
    <a href="skipLogin">登陆</a>
</div>
<div>
    <p>${error2}</p>
</div>
</body>
</html>

