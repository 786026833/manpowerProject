<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
        p{
            cursor: pointer;
            display: inline-block;
            width: 100px;
            height: 40px;
            border: 1px solid black;
            text-align: center;
            line-height: 40px;
        }
        #queryDiv{
            width: 500px;
            text-align: center;
            border: 1px solid blue;
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
<div id="queryDiv">
    <table>

        <tr>
            <th>奖惩信息编号</th>
            <th>奖惩</th>
            <th>原因</th>
            <th>时间</th>
            <th>金额</th>
            <th>员工编号</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${sessionScope.rps}" var="r">
            <tr>
                <td>${r.rpId}</td>
                <td>${r.reName}</td>
                <td>${r.rpCause}</td>
                <td><fmt:formatDate value="${r.rpTime}" type="Date" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td>${r.rpSal}</td>
                <td>${r.eId}</td>
                <td><a href="skipUpdateRewardPunishment?rpId=${r.rpId}">修改</a></td>
                <td><a href="deleteRewardPunishment?rpId=${r.rpId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="skipRewardPunishment">返回</a>
</body>
</html>
