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
        *{
            margin: 0;
            padding: 0;
        }
       #div3{
           background-color: aqua;
           text-align: center;
       }
        a,p{
            cursor: pointer;
            display: inline-block;
            margin-left: 50px;
        }
    </style>
    <script  src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#input1").focus(function () {
                $("#span").css("display","none");
            });
        })
    </script>
</head>
<body>
<div id="div3">
    <c:choose>
        <c:when test="${!empty sessionScope.departments}">
            <table>
                <tr>
                    <th>部门编号</th>
                    <th>部门名称</th>
                    <th>创建时间</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="d" items="${sessionScope.departments}">
                    <tr>
                        <form action="updateteDepartment" method="post">
                            <td><a href="?dId=${d.dId}">${d.dId}</a></td>
                            <td><input id="input1" type="text" name="dName" value="${d.dName}"></td>
                            <td><input  type="hidden" name="dId" value="${d.dId}"></td>
                            <td>${d.dTime}</td>
                            <td><input type="submit" value="修改"></td>
                            <td><a href="deleteDepartment?dId=${d.dId}">撤销</a></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </c:when>
        <c:otherwise>
            ${暂时还没有任何的部门信息}
        </c:otherwise>
    </c:choose>
    <span id="span">${sessionScope.error7}</span>

</div>
<a href="skipDepartment">返回</a>
</body>
</html>
