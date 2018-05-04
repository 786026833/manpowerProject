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
        /*表格去除空格*/
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
    <div id="div1">

        <form action="updateTrain" method="post">
            <table>
                <tr><th  colspan="2"><h1>培训信息表</h1></th></tr>
                <tr><th>培训主题</th><td><input type="text" name="tTitle" value="${oneTrain.tTitle}"></td></tr>
                <tr><th>培训部门</th><td><input type="text" name="tTrainee" readonly="readonly"  value="${oneTrain.tTrainee}"></td></tr>
                <tr><th>培训内容</th><td><textarea name="tContent" style="width:200px;height:80px;" required="required">value="${oneTrain.tContent}</textarea></td></tr>
                <tr><th>开始时间</th><td><input type="datetime-local" name="tBeginTime" value="${oneTrain.tBeginTime}" placeholder="时间" required="required"></td></tr>
                <tr><th>结束时间</th><td><input type="datetime-local" name="tEndTime" value="${oneTrain.tEndTime}"  placeholder="时间" required="required"></td></tr>
                <tr><th>培训地点</th><td><input type="text" name="tSite" required="required" value="${oneTrain.tSite}"></td></tr>
                <tr><th></th><td></td></tr>
                <tr><th></th><td></td></tr>
            </table>
            <input type="hidden" name="tId" value="${oneTrain.tId}"><br>
            <input type="submit" value="确认修改">    <input type="reset" value="重置"> <a href="deleteTrain?tId=${oneTrain.tId}">删除</a>
        </form>
    </div>
<a href="skipAllTrain">返回</a>
</body>
</html>
