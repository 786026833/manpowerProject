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
        }
        th,td {
            border:1px solid black;
            width: 100px;
            text-align: center;
        }
        #div2{
            display: none;
        }
    </style>
</head>
<body>
<div id="queryDiv">
    <span>${sessionScope.succeed}</span>

    <table>
        <tr>
            <th>信息ID</th>
            <th>简历编号</th>
            <th>简历投递时间</th>
            <th>查阅</th>
        </tr>
        <c:if test="${empty sessionScope.resumeDds}">
            <span>暂时没收到简历</span>
        </c:if>
        <c:forEach var="resumeDd" items="${sessionScope.resumeDds}">
            <tr>
                <td>${resumeDd.rdId}</td>
                <td>${resumeDd.rId}</td>
                <td>${resumeDd.rdTime}</td>
                <td>${resumeDd.rdState}</td>
                <td><a href="selectResume?rId=${resumeDd.rId}&rdId=${resumeDd.rdId}">查阅</a></td>
                <td><a href="deleteResumeDd?rdId=${resumeDd.rdId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
   <%-- 分页
   <c:forEach var="num" begin="1" end= "${sessionScope.totalPages}">
        <a href="selectInformation?currentPage=${num}&power=1">${num}</a>
    </c:forEach>
    --%>
    <a href="skipRecruit">返回</a>
</div>
</body>
</html>
