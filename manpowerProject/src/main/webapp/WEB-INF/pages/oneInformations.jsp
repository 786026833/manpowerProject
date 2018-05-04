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
        table {
            border-collapse:collapse;
            border:1px solid black;
            margin: 0 auto;
        }
        th,td {
            border:1px solid black;
            width: 100px;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="div1" >

    <form action="updateInformation" method="post">
       <table>
           <tr><th colspan="2"><h1>招聘信息</h1></th></tr>
           <tr><th>标题</th><td><input type="text" name="recTitle" value="${sessionScope.oneInformations.recTitle}"></td></tr>
           <tr><th>部门</th><td><input type="text" name="dId" value="${sessionScope.oneInformations.dId}"></td></tr>
           <tr><th> 职位</th><td><input type="text" name="pId" value="${sessionScope.oneInformations.pId}"></td></tr>
           <tr><th>信息简述</th><td><textarea  name="recContent" style="width:200px;height:80px;" required="required">
               ${sessionScope.oneInformations.recContent}
           </textarea></td></tr>
       </table>
        <%--职位部门应显示名字，并且能直接选择，此功能还有待实现--%>
        <input type="hidden" name="recId" value="${sessionScope.oneInformations.recId}"><br>
        <input type="hidden" name="time" value="0">
        <input type="submit" value="修改">  <a href="deleteInformation?recId=${sessionScope.oneInformations.recId}">删除</a>
    </form>
</div>
<a href="skipRecruit">返回</a>
</body></html>
