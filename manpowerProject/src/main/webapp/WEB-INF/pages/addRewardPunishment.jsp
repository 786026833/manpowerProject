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
    <style type="text/css">
        /*表格去除空格*/
        table {
            border-collapse:collapse;
            border:1px solid black;
            margin:0px auto;
            text-align: center;
        }
        td,th {
            border:1px solid black;
        }
        #div1{
            background-color:lavenderblush;
            text-align: center;
            width: 600px;
            height: 600px;
            margin: 0 auto;
        }
    </style>
    <script type="text/javascript">
        function dep_pos(dId) {
            <c:forEach items="${departments}" var="d">
                if(dId.value==${d.dId}){
                    var pe =document.getElementById("pId");
                    pe.options.length=0;
                    <c:forEach items="${d.positions}"  var="p">
                    var option=document.createElement("option");
                    option.innerHTML="${p.pName}";
                    option.value=${p.pId};
                    pe.append(option);
                    </c:forEach>
                }
            </c:forEach>
        }
        function pp(pId) {
            <c:forEach items="${departments}" var="d">
            <c:forEach items="${d.positions}" var="p">
            if(pId.value==${p.pId}){
                var pe =document.getElementById("eId");
                pe.options.length=0;
                <c:choose>
                    <c:when test="${!empty p.employees}">
                        <c:forEach items="${p.employees}"  var="e">
                            var option=document.createElement("option");
                            option.innerHTML="${e.eName}";
                            option.value=${e.eId};
                            pe.append(option);
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        var option=document.createElement("option");
                        option.innerHTML="暂时没有员工";
                        pe.append(option);
                    </c:otherwise>
                </c:choose>

            }
            </c:forEach>
            </c:forEach>
        }
    </script>
</head>
<body>
<div id="div1">

    <form action="addRewardPunishment1" method="post">
        <table>
            <tr><th  colspan="2"><h1>奖惩信息表</h1></th></tr>
            <tr><th>选择部门</th><td> <select name="eDid" onchange="dep_pos(this)">
                <c:forEach items="${departments}" var="d">
                    <option  value="${d.dId}">${d.dName}</option>
                </c:forEach>
            </select></td></tr>
            <tr><th>选择职位</th><td><select name="ePid" id="pId" onchange="pp(this)">
                <c:forEach items="${departments[0].positions}" var="p">
                    <option  value="${p.pId}">${p.pName}</option>
                </c:forEach>
            </select></td></tr>
            <tr><th>选择员工</th><td><select name="eId" id="eId" >
                <c:forEach items="${departments[0].positions}" var="p">
                    <c:forEach items="${p.employees}" var="e">
                        <option value="${e.eId}">${e.eName}</option>
                    </c:forEach>
                </c:forEach>
            </select></td></tr>
            <tr><th>奖　　惩</th><td><select name="reName" >
                <option  value="奖励">奖励</option>
                <option  value="惩罚">惩罚</option>
            </select></td></tr>
            <tr><th>原　　因</th><td><textarea name="rpCause" style="width:200px;height:80px;" required="required"></textarea></td></tr>
            <tr><th>金　　额</th><td><input type="text" name="rpSal"  placeholder=请输入金额" required="required"
                                        pattern="^[1-9]\d*$" title="不能是负数或者字母"></td></tr>
        </table>
        <input type="submit" value="添加"> <input type="reset" value="重置">
    </form>

</div>
<a href="skipRewardPunishment">返回</a>
</body>
</html>
