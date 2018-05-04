<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
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
        #div2{
            display: none;
        }
        #p1{
            cursor: pointer;
            display: block;

        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body>
<div>
    <span>${error}</span>
    <p>欢迎 <span style="color: green">${sessionScope.user.uName}</span> 进入人力资源网站</p>
    <a href="selectInformation?currentPage=1&p=2">招聘信息</a><br>
    <a href="skipResume?permission=1">填写简历</a><%--permission访问权限--%>
    <p id="p1">查看简历</p>
    <div id="div2">
        <c:if test="${empty sessionScope.resume}">
            还没有简历，请先去填写简历
        </c:if>
        <c:if test="${!empty sessionScope.resume}">
            <c:forEach var="resume" items="${sessionScope.resume}">
                简历编号：<a href="skipQueryResume?permission=1&resume=${resume.rId}">${resume.rId}</a><br>
            </c:forEach>
        </c:if>
    </div>
    <a href="selectInterviewInvitation?uId=${sessionScope.user.uId}&permission=1">查看面试邀请</a>
    <a href="skipIndex">退出登陆</a>
</div>
<script>
    document.getElementById("p1").onclick=function () {
        document.getElementById("div2").style.display="block";
    }
</script>
</body>
</html>
