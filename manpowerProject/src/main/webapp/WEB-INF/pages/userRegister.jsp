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
<div style="background-color: gold;width: 300px;text-align: center;margin: auto">
    <span>${sessionScope.error1}</span>
    <form action="register" method="post">
        请输入账号：<input type="text" name="uName" placeholder="请输入账号" required="required"><br>
        请输入密码：<input type="password" name="uPass" placeholder="请输入密码" required="required"><br>
        <input type="submit" value="注册">
    </form>
</div>
</body>
</html>
