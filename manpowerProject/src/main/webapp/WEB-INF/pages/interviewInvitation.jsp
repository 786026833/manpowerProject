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

        <c:if test="${empty sessionScope.interviewInvitations}">
            还没有面试邀请信息
        </c:if>
        <c:if test="${!empty sessionScope.interviewInvitations}">
            <table>
                <tr>
                    <th>信息ID</th>
                    <th>面试时间</th>
                    <th>面试地点</th>
                    <th></th>
                </tr>
                <c:forEach var="iis" items="${sessionScope.interviewInvitations}">
                    <tr>
                        <td>${iis.iId}</td>
                        <td>${iis.iInterviewTime}</td>
                        <td>${iis.iInterviewSite}</td>
                        <c:if test="${iis.iState==0}">
                            <td>已确认面试</td>
                        </c:if>
                        <c:if test="${iis.iState==1}">
                            <td><a href="updateInterviewInvitation?iId=${iis.iId}">确认面试</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    <%-- 分页
    <c:forEach var="num" begin="1" end= "${sessionScope.totalPages}">
         <a href="selectInformation?currentPage=${num}&power=1">${num}</a>
     </c:forEach>
     --%>
    <a href="skipWelcome">返回</a>
</div>
</body>
</html>
