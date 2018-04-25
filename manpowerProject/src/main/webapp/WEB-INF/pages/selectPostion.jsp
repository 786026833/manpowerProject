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
                            <td><a href="?pId=${p.pId}">${p.pId}</a></td>
                            <td><input id="input1" type="text" name="pName" value="${p.pName}"></td>
                            <td><input  type="text" name="pSalary" value="${p.pSalary}"></td>
                            <td><a href="?dId=${p.dId}">${p.dId}</a></td>
                            <td><input type="submit" value="修改"></td>
                            <td><a href="deletePosition?dId=${p.dId}">撤销</a></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </c:when>
        <c:otherwise>
            ${暂时还没有任何的信息}
        </c:otherwise>
    </c:choose>
    <span id="span">${sessionScope.error7}</span>

</div>
<a href="skipPosition">返回</a>
</body>
</html>
