<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <style>
       #div1{
           background-color: greenyellow;
           text-align: center;
       }
    </style>
</head>
<body>
  <div id="div1">
      <a href="selectResumeDd?pow=2">添加员工</a>
      <a href="selectEmployee">查看员工</a>
  </div>
  <a href="skipAdministratorPages">返回</a>
</body>
</html>
