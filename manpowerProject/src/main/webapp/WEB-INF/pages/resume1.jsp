<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>d
    <base href="<%=basePath%>"/>
    <title></title>
    <style type="text/css">
        #p1{
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
      /*  table {
            border-collapse:collapse;
            border:1px solid black;
        }
        th,td {
            border:1px solid black;
            width: 100px;
            text-align: center;
        }*/
        #div2{
            display: none;
        }
    </style>
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
        <p id="p1">通知面试</p>
        <div id="div2">
            <form action="addInterviewInvitation" method="post">
                面试时间：<input type="datetime-local" name="iInterviewTime" placeholder="时间" required="required"><br>
                面试地点：<input type="text" name="iInterviewSite" placeholder="地点" required="required"><br>
                <input type="hidden" name="uId" value="${sessionScope.oneResume.uId}">
                <input type="hidden" name="rId" value="${sessionScope.oneResume.rId}">
                <input type="submit" value="发送面试邀请" id="inp1">
            </form>
        </div>
    </c:if>
    <a href="skipResumeDd">返回</a>

</div>
<script>
    document.getElementById("p1").onclick=function () {
        document.getElementById("div2").style.display="block";
    }
    document.getElementById("inp1").onclick=function () {
        document.getElementById("div2").style.display="none";
    }
</script>
</body>
</html>
