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
      <a href="skipDepartment">部门管理</a><br>
      <a href="addD_Position">职位管理</a><br>
      <a href="skipAdm_empl">员工管理</a><br>
      <a href="skipSalary">薪资管理</a><br>
      <a href="skipSelectCheck">考勤管理</a><br>
      <a href="skipTrain">培训管理</a><br>
      <a href="skipRecruit">招聘管理</a><br>
      <a href="skipRewardPunishment">奖惩信息管理</a><br>
  </div>
  <a href="skipIndex">退出登录</a>
</body>
</html>
