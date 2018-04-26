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
        table {
            border-collapse:collapse;
            border:1px solid black;
            margin:0px auto;
            text-align: center;
        }
        td,th {
            border:1px solid black;
        }
    </style>
</head>
<body>
<div>
    <span>${error}</span>
    <table>
        <tr>
            <th>主题</th>
            <th>培训内容</th>
            <th>培训部门</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>地点</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${sessionScope.trains}" var="train">
            <tr>
                <td>${train.tTitle}</td>
                <td>${train.tContent}</td>
                <td>${train.tBeginTime}</td>
                <td>${train.tTrainee}</td>
                <td>${train.tEndTime}</td>
                <td>${train.tSite}</td>
                <td><a href="selectOneTrain?tId=${train.tId}">修改</a></td>
                <td><a href="deleteTrain?tId=${train.tId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="skipTrain">返回</a>
</div>
</body>
</html>
