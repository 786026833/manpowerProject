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
    <span>${sessionScope.error5}</span>
    <a href="skipAddRecruitmentInfor">发布招聘信息</a><br>
    <a href="admSelectInformation?currentPage=1">查看已发布的招聘信息</a><br>
    <a href="selectResumeDd">查看收到的简历</a><br>
    <a href="skipAdministratorPages">返回</a>
</div>
</body>
</html>
