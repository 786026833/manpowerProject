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

    <form action="addResume" method="post">
        <table>
            <tr><th colspan="2"><h1>简　　历</h1></th></tr>
            <tr> <th>姓　　名：</th><td><input type="text" name="rName" required="required"></tr>
            <tr> <th>性　　别：</th><td> <input type="text" name="rSex" required="required"></td></tr>
            <tr> <th> 联系电话：</th><td> <input type="text" name="rPhone" required="required"></td></tr>
            <tr> <th>年　　龄：</th><td><input type="text" name="rAge"></td></tr>
            <tr> <th>学　　历：</th><td><input type="text" name="rEducation" required="required"></td></tr>
            <tr> <th> 工作经历：</th><td><textarea name="rWorkExperience" style="width:200px;height:80px;" required="required"></textarea></td></tr>
            <tr> <th>求职意向：</th><td> <input type="text" name="rCareerObjective"></td></tr>
        </table>
        <input type="hidden" name="uId" value="${sessionScope.user.uId}">
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
    <a href="skipWelcome">返回</a>
</div>
</body>
</html>
