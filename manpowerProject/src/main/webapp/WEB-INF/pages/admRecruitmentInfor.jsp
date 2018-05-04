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
        #div2{
            display: none;
        }
    </style>

</head>
<body>
<div id="queryDiv">

    <table>
        <tr><th colspan="2"> <h2>招聘信息</h2></th></tr>
        <tr>
            <th>标题</th>
            <th>状态（1.发布 0.未发布）</th>
            <th>发布时间</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="rInf" items="${sessionScope.informations}">
            <tr>
                <td><a href="oneInformation?recId=${rInf.recId}">${rInf.recTitle}</a></td>
                <td>${rInf.recState}</td>
                <c:choose>
                    <c:when test="${rInf.recState==0}">
                        <td></td>
                        <td><a href="oneInformation?recId=${rInf.recId}">修改</a></td>
                        <td><a href="updateInformation?recId=${rInf.recId}&time=1">发布</a></td>
                    </c:when>
                    <c:otherwise>
                        <td><fmt:formatDate value="${rInf.recTime}" type="Date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td></td>
                        <td></td>
                    </c:otherwise>
                </c:choose>
                <td><a href="deleteInformation?recId=${rInf.recId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <c:forEach var="num" begin="1" end= "${sessionScope.totalPages}">
        <a href="admSelectInformation?currentPage=${num}&power=1">${num}</a>
    </c:forEach>
    <a href="skipRecruit">返回</a>
</div>
<%--分也查询没做出来  原因; 穿的参数是对的 查询语句再后台页能查出来
   但是在网页中 得不到结果
--%>
</body>
</html>
