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
<span>${erroe}</span>
 <div>
     <a href="skipAddTrain">添加培训信息</a><br>
     <a href="selectTrain">查看培训信息</a>
 </div>
<a href="skipAdministratorPages">返回</a>
</body>
</html>
