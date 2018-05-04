<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<div>
    <p>欢迎游客进入人力资源网站</p>
    <a href="selectInformation?currentPage=1&p=1">招聘信息</a><br>
    <a href="skipResume?permission=2">填写简历</a><br>
    <a href="skipQueryResume?permission=2&resume=0">查看简历</a><br>
    <a href="selectInterviewInvitation?&permission=2">查看面试邀请</a><br>
    <a href="skipUserRegister">注册账号</a>
    <form action="skipLogin" method="post">
        <select name="myselect" id="myselect">
            <option value="opt1">用户</option>
            <option value="opt2">管理员</option>
            <option value="opt3">员工</option>
        </select>
        <input type="submit" value="登陆"/>
    </form>
</div>
<div>
    <p>${error2}</p>
</div>
</body>
</html>

<%--
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body>
<input type="button" value="点我" onclick=" prompt('请输入');" />
<script>

       prompt(function () {
           var judge = prompt("随便输入点什么？");
           if (judge) {

              /* document.write("输入的内容为："+judge+"。");*/
           } else {
              /* document.write("取消就没了哦。");*/
           }
       })


</script>
</body>
</html>
--%>
