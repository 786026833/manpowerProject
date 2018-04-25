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
        *{
            margin: 0;
            padding: 0;
        }
        #div1{
            background-color: aqua;
            text-align: center;

        }
        #div2{
            display: none;
        }
        a,p{
            cursor: pointer;
            display: inline-block;
            margin-left: 50px;
        }
    </style>
    <script  src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#p1").click(function () {
                $("#div2").css("display","block");
                $("#span").css("display","none");
            });
            $("#input1").click(function () {
                $("#div2").css("display","none");
            });
            $("#a2").click(function () {
                $("#span").css("display","none");
                $("#div2").css("display","none");
            });
        })
    </script>
</head>
<body>
<div id="div1">
    <div>
        <p id="p1">创建部门</p>   <a href="selectDepartment" id="a2">查看部门</a><%--<a href="">修改部门</a> <a href="">删除部门</a>--%>
        <div id="div2">
            <form action="addDepartment" method="post">
                部门名称：<input type="text" name="dName" placeholder="部门名称" required="required"><br>
                <input type="submit" value="添加" id="input1">
            </form>
        </div>

    </div>
    <span id="span">${sessionScope.error8}</span>

</div>
<a href="skipAdministratorPages">返回</a>
</body>
</html>
