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
<div>
    <c:choose>
        <c:when test="${empty checks}">
            还没有考勤信息
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>信息ID</th>
                    <th>上班时间</th>
                    <th>下班时间</th>
                    <th>迟到</th>
                    <th>早退</th>
                    <th>旷工</th>
                    <th>员工编号</th>
                </tr>
                <c:forEach items="${checks}" var="c">
                    <tr>
                        <td>${c.cId}</td>
                        <td><fmt:formatDate value="${c.cWorkTime}" type="Date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${c.cOffworkTine}" type="Date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${c.cLate}</td>
                        <td>${c.cLeave}</td>
                        <td>${c.cAbsenteeism}</td>
                        <th>${c.eId}</th>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <a href="skipAdministratorPages">返回</a>
</div>

</body>
</html>
