<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            margin: 0 auto;
            background-color: aquamarine;

        }
        div{
            text-align:center;
        }
    </style>
</head>
<body>
<div id="div1">

    <span>欢迎员工${employee.eName}进入系统</span><br>
    <div>
    <span>
        <c:if test="${employee.eTrain==1}" >
            您有新的培训通知，请及时查看
        </c:if>
    </span>
    <span>${error}</span>
    </div>
    <a href="skipEmployeeInfo?eId=${employee.eId}">查看个人信息</a><br>
    <a href="skipAllPages?eId=${employee.eId}">公司各部门及职位员工信息</a><br>
    <a href="queryTrain?eId=${employee.eId}&trId=${employee.eDid}">查看培训信息</a><br>
    <a href="skipQueryRewardPunishment?eId=${employee.eId}">查看奖惩信息</a><br>
    <a href="queryEmplCheck?eId=${employee.eId}">查询考勤信息</a><br>
    <a href="querySalary?eId=${employee.eId}">薪资信息</a><br>
    <div>
        <a href="addCheck?eId=${employee.eId}">上班打卡</a><br>
        <a href="addCheck1?eId=${employee.eId}">下班打卡</a>
    </div>
    <a href="skipIndex">退出登录</a>
</div>
</body>
</html>
