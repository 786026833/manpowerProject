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
    <c:if test="${!empty sessionScope.resume1}">
        简历编号：<span>${resume1.rId}</span>
        <form action="updateResume" method="post">
            姓　　名：<input type="text" name="rName" value="${resume1.rName}"><br>
            性　　别：<input type="text" name="rSex" value="${resume1.rSex}"><br>
            联系电话：<input type="text" name="rPhone" value="${resume1.rPhone}"><br>
            年　　龄：<input type="text" name="rAge" value="${resume1.rAge}"><br>
            学　　历：<input type="text" name="rEducation" value="${resume1.rEducation}"><br>
            工作经历：<br>
            <textarea type="text" name="rWorkExperience" style="width:200px;height:80px;" required="required">
                    ${resume1.rWorkExperience}
            </textarea><br>
            求职意向：<input type="text" name="rCareerObjective"  value="${resume1.rCareerObjective}" ><br>
            <input type="hidden"  name="rId" value="${resume1.rId}">
            <input type="hidden"  name="user.uId" value="${resume1.user.uId}">
            <input type="submit" value="确认修改">
            <input type="reset" value="重置">
        </form>
    </c:if>
        <a href="deleteResume1?resumeRId=${sessionScope.resume1.rId}">删除此简历</a>
        <a href="skipWelcome">返回</a>
</div>
</body>
</html>
