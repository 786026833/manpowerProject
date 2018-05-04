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
            display: inline-block;
            margin-left: 40px;
           /* border: 1px solid black;*/
            background-color: darkgray;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div id="div3">
    <c:choose>
        <c:when test="${!empty sessionScope.positions}">
            <table>
                <tr>
                    <th>职位编号</th>
                    <th>职位名称</th>
                    <th>基本薪资</th>
                    <th>所在部门的编号</th>
                    <th></th>
                </tr>
                <c:forEach var="p" items="${sessionScope.positions}">
                    <tr>
                        <form action="updatePosition" method="post">
                            <td><a href="pos_employee?pId=${p.pId}&num=2">${p.pId}</a></td>
                            <td><input id="input1" type="text" name="pName" value="${p.pName}"></td>
                            <td><input  type="text" name="pSalary" value="${p.pSalary}"></td>
                            <td><a href="?dId=${p.dId}"><input type="text" name="dId" value="${p.dId}" ></a></td>
                            <input type="hidden" name="pId" value="${p.pId}" >
                            <td><input type="submit" value="修改"></td>
                            <td><a href="deletePosition?pId=${p.pId}">撤销</a></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </c:when>
        <c:otherwise>
            暂时还没有任何的信息
        </c:otherwise>
    </c:choose>
    <span id="span">${sessionScope.error9}</span>

</div>
<a href="skipPosition">返回</a>
</body>
</html>
