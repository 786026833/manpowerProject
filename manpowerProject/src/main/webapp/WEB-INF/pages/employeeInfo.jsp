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
<div >
    <span>${error}</span>
    <form action="updateEmployee1" method="post">
    <table>
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>员工密码</th>
            <th>联系电话</th>
            <th>性别</th>
            <th>年龄</th>
            <th>任职状态</th>
            <th>部门名称</th>
            <th>职位名称</th>
            <th>入职日期</th>
            <th></th>
        </tr>
            <tr>
                <td>${employee.eId}</td>
                <td>${employee.eName}</td>
                <td><input type="text" name="ePass" value="${employee.ePass}"></td>
                <td><input type="text" name="ePhone" value="${employee.ePhone}"></td>
                <td>${employee.eSex}</td>
                <td>${employee.eAge}</td>
                <td>${employee.eState}</td>
                <td>${department.dName}</td>
                <td>${position.pName}</td>
                <td>
                    <fom:formatDate value="${employee.eJoinDate}" type="Date" pattern="yyyy-MM-dd hh:mm:ss"/>
                </td>
                <td>
                    <input type="hidden" name="eId" value="${employee.eId}">
                    <input type="submit" value="修改">
                </td>
            </tr>
    </table>
</form>
</div>
    <a href="skipEmployeePages?eId=${employee.eId}">返回</a>


</body>
</html>
