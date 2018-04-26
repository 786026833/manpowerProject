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
            background-color:lavenderblush;
            text-align: center;
            width: 600px;
            height: 600px;
        }
    </style>
</head>
<body>
<div id="div1">

    <h1>简　　历</h1>
    <form action="addResume" method="post">
        姓　　名：<input type="text" name="rName" required="required"><br>
        性　　别：<input type="text" name="rSex" required="required"><br>
        联系电话：<input type="text" name="rPhone" required="required"><br>
        年　　龄：<input type="text" name="rAge"><br>
        学　　历：<input type="text" name="rEducation" required="required"><br>
        工作经历：<br>
        <textarea name="rWorkExperience" style="width:200px;height:80px;" required="required"></textarea><br>
        求职意向：<input type="text" name="rCareerObjective"><br>
        <input type="hidden" name="uId" value="${sessionScope.uId}">
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
    <a href="skipWelcome">返回</a>
</div>
</body>
</html>
