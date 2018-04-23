<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <style type="text/css">
        #div1{
            width: 500px;
            height:400px;
            background-color: aqua;
            text-align: center;
        }
    </style>
</head>
<body>
  <div id="div1">
      <a href="">部门管理</a><br>
      <a href="">薪资管理</a><br>
      <a href="">考勤管理</a><br>
      <a href="">培训管理</a><br>
      <a href="skipRecruit">招聘管理</a><br>
      <a href="">奖惩信息管理</a><br>
  </div>
</body>
</html>
