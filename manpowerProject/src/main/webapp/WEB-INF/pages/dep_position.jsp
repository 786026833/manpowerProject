<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fom" uri="http://java.sun.com/jstl/fmt_rt" %>
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
        /*超链接去除下划线 带边框*/
        a{
            /*display: inline-block;*/
            /*margin-left: 40px;*/
            /*border: 1px solid black;*/
            text-decoration: none;
        }
    </style>
</head>
<body>
<div>
    <table>
        <tr>
            <th>职位编号</th>
            <th>职位名称</th>
            <th>基本薪资</th>
        </tr>
        <c:forEach items="${sessionScope.positions}" var="pos">
            <tr>
                <td><a href="pos_employee?pId=${pos.pId}&num=1">${pos.pId}</a></td>
                <td>${pos.pName}</td>
                <td>${pos.pSalary}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="skipSelectDepartment">返回</a>
</div>
</body>
</html>
