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
        /*表格去除空格*/
        table {
            border-collapse:collapse;
            border:1px solid black;
            margin:0 auto;
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
    <c:choose>
        <c:when test="${empty sessionScope.p1}">
            该职位暂时还没有员工
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>职位编号</th>
                    <th>职位名称</th>
                    <th>基本薪资</th>
                    <th>所在部门</th>
                </tr>
                <c:forEach items="${sessionScope.p1}" var="pos">
                    <tr>
                        <td><a href="queryAllemployee1?pId=${pos.pId}&num=1&eId=${employee.eId}">${pos.pId}</a></td>
                        <td>${pos.pName}</td>
                        <td>${pos.pSalary}</td>
                        <td>
                            <c:forEach items="${sessionScope.d1}" var="d">
                                <c:if test="${d.dId==pos.dId}">
                                    ${d.dName}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <a href="skipAllPages?eId=${employee.eId}">返回</a>
</div>
</body>
</html>
