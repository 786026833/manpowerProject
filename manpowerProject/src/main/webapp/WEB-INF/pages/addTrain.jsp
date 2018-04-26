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
        <span>${erroe}</span>
        <form action="addTrain" method="post">
            培训主题：<input type="text" name="tTitle"><br>
            培训内容：<br>
            <textarea name="tContent" style="width:200px;height:80px;" required="required"></textarea><br>
            培训部门：
            <select name="trId">
                <c:forEach items="${sessionScope.d}" var="d">
                    <option value="${d.dId}">${d.dName}</option>
                </c:forEach>
            </select><br>
            开始时间：<input type="datetime-local" name="tBeginTime" placeholder="时间" required="required"><br>
            结束时间:<input type="datetime-local" name="tEndTime" placeholder="时间" required="required"><br>
            地点：<input type="text" name="tSite" required="required"><br>
            <input type="submit" value="添加">    <input type="reset" value="重置">
        </form>
    </div>
<a href="skipTrain">返回</a>
</body>
</html>
