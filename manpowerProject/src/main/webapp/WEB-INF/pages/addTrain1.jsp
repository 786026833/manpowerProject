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
            background-color: greenyellow;
        }
    </style>
</head>

<body>
    <div id="div1">
        <form action="updateTrain" method="post">
            培训主题：<input type="text" name="tTitle" value="${oneTrain.tTitle}">br
            培训内容：
            <textarea name="tContent" style="width:200px;height:80px;" required="required">value="${oneTrain.tContent}</textarea><br>
            培训部门：<input type="text" name="tTrainee" readonly="readonly"  value="${oneTrain.tTrainee}"><br>
            </select><br>
            开始时间：<input type="datetime-local" name="tBeginTime" value="${oneTrain.tBeginTime}" placeholder="时间" required="required"><br>
            结束时间:<input type="datetime-local" name="tEndTime" value="${oneTrain.tEndTime}"  placeholder="时间" required="required"><br>
            地点：<input type="text" name="tSite" required="required" value="${oneTrain.tSite}"><br>
            <input type="hidden" name="tId" value="${oneTrain.tId}"><br>
            <input type="submit" value="确认修改">    <input type="reset" value="重置"> <a href="deleteTrain?tId=${oneTrain.tId}">删除</a>
        </form>
    </div>
<a href="skipAllTrain">返回</a>
</body>
</html>
