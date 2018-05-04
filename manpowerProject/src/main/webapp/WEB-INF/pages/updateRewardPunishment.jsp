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
    <style type="text/css">
        #div1{
            background-color:lavenderblush;
            text-align: center;
            width: 600px;
            height: 400px;
        }
        table {
            border-collapse:collapse;
            border:1px solid black;
            margin:0 auto;
            text-align: center;
        }
        td,th {
            border:1px solid black;
        }
    </style>
</head>
<body>
<div id="div1">
    <form action="updateRewardPunishment" method="post">
        <table>
            <tr><th  colspan="2"><h1>奖惩信息表</h1></th></tr>
            <tr><th>信息编号</th><td><input type="text" name="rpId" value="${rewardPunishment.rpId}" readonly="readonly"></td></tr>
            <tr><th>奖　　惩</th><td><input type="text" readonly="readonly" name="reName" value="${rewardPunishment.reName}"></td></tr>
            <tr><th>原　　因</th><td><textarea name="rpCause" style="width:200px;height:80px;" required="required">${rewardPunishment.rpCause}</textarea></td></tr>
            <tr><th>时　　间</th><td><fmt:formatDate value="${rewardPunishment.rpTime}" type="Date" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
            <tr><th>金　　额</th><td> <c:choose>
                <c:when test="${rewardPunishment.rpSal<0}">
                    <input type="text" name="rpSal"  placeholder=请输入金额" required="required"
                           pattern="^[1-9]\d*$" title="不能是负数或者字母" value="${-rewardPunishment.rpSal}"><br>
                </c:when>
                <c:otherwise>
                    <input type="text" name="rpSal"  placeholder=请输入金额" required="required"
                           pattern="^[1-9]\d*$" title="不能是负数或者字母" value="${rewardPunishment.rpSal}"><br>
                </c:otherwise>
            </c:choose></td></tr>
            <tr><th>员工编号</th><td><input type="text" name="eId" value="${rewardPunishment.eId}" readonly="readonly"></td></tr>
        </table>
        <input type="submit" value="确认修改"> <input type="reset" value="重置">
    </form>

</div>
<a href="skipAllRewardPunishment">返回</a>
</body>
</html>
