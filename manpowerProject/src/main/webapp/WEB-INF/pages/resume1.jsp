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
<div id="queryDiv">
    <c:if test="${!empty sessionScope.oneResume}">
        简历编号：<span>${sessionScope.resumeDd.rdId}</span>
            姓　　名：${sessionScope.oneResume.rName}<br>
            性　　别：${sessionScope.oneResume.rSex}<br>
            联系电话：${sessionScope.oneResume.rPhone}<br>
            年　　龄：${sessionScope.oneResume.rAge}<br>
            学　　历：${sessionScope.oneResume.rEducation}<br>
            工作经历：<br>
            <textarea  name="rWorkExperience" style="width:200px;height:80px;" required="required">
                    ${sessionScope.oneResume.rWorkExperience}
            </textarea><br>
            求职意向：${sessionScope.oneResume.rCareerObjective} <br>
        <a href="deleteResumeDd?rdId=${sessionScope.resumeDd.rdId}">删除此简历</a>
        <a href="?rId=${sessionScope.resumeDd.rdId}">通知面试</a>
    </c:if>
    <a href="skipResumeDd">返回</a>
</div>
</body>
</html>
