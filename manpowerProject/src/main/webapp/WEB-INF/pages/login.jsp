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
<fieldset>
    <legend>用户登录</legend>
    <form action="login" method="post">
        用户名：<input type="text" name="uName" placeholder="请输入用户名" required="required"><br>
        密　码：<input type="password" name="uPass" placeholder="请输入密码" required="required"><br>
        记住密码：<input type="checkbox" name="auto" value="auto"><br>
        <input type="submit" value="登录"> <a href="autoLogin" style="text-decoration:none;
            display: inline-block;margin-left: 50px;border: 1px solid black;background-color: darkgrey">自动登录</a>
    </form>
    <h4 style="color: red">${error}</h4>
</fieldset>
</body>
</html>

