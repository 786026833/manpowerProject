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
<div id="div1" >
    <form action="updateInformation" method="post">
        <h1>招聘信息</h1>
        标题：<input type="text" name="recTitle" value="${sessionScope.oneInformations.recTitle}"><br>
        信息简述：<textarea  name="recContent" style="width:200px;height:80px;" required="required">
            ${sessionScope.oneInformations.recContent}
        </textarea><br>
        <input type="hidden" name="recId" value="${sessionScope.oneInformations.recId}"><br>
        <input type="submit" value="重新发布">  <a href="deleteInformation?recId=${sessionScope.oneInformations.recId}">删除</a>
    </form>
</div>
<a href="skipRecruit">返回</a>
</body></html>
