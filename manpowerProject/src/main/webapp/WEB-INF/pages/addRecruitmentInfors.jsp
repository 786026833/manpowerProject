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

    <h1>发布招聘信息</h1>
    <form action="addInformation" method="post">
        标　　题：<input type="text" name="recTitle" required="required"><br>
        信息简述：<br>
        <textarea name="rWorkExperience" style="width:200px;height:80px;" required="required"></textarea><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
    <a href="skipRecruit">返回</a>
</div>
</body>
</html>
