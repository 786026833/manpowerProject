<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
    <span>${sessionScope.succeed}</span>
    <h2>招聘信息</h2>
    <table>
        <tr>
            <th>标题</th>
            <%--<th>招聘部门</th>
            <th>招聘职位</th>--%>
            <th>详细信息</th>
            <th>发布时间</th>
            <th>投递简历</th>
        </tr>
        <c:forEach var="rInf" items="${sessionScope.recruitmentInformations}">
        <c:if test="${rInf.recState==1}" >
            <tr>
                <td>${rInf.recTitle}</td>
                    <%-- <td>${rInf.recTitle}</td>
                     <td>${rInf.recTitle}</td>--%>
                <td>${rInf.recContent}</td>
                <td><fmt:formatDate value="${rInf.recTime}" type="Date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><p id="p1">投递简历</p>
                    <div id="div2">
                        <c:forEach var="resume" items="${sessionScope.resume}">
                            简历编号：<a href="addResumeDd?permission=1&rId=${resume.rId}&recId=${rInf.recId}">${resume.rId}</a><br>
                        </c:forEach>
                    </div>
                </td>
            </tr>
        </c:if>
        </c:forEach>
    </table>
    <c:forEach var="num" begin="1" end= "${sessionScope.totalPages}">
        <a href="selectInformation?currentPage=${num}&power=1">${num}</a>
    </c:forEach>
        <a href="skipWelcome">返回</a>
</div>



<%--分也查询没做出来  原因; 穿的参数是对的 查询语句再后台页能查出来
   但是在网页中 得不到结果
--%>
<script>
    document.getElementById("p1").onclick=function () {
        document.getElementById("div2").style.display="block";
    }
</script>
</body>
</html>
