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
        #div1{
            background-color:lavenderblush;
            text-align: center;
            width: 600px;
            height: 600px;
        }
    </style>
    <script type="text/javascript">
            function select_change(did)
            {

                <c:forEach items="${sessionScope.departments}" var="departments">
                   if(did.value==${departments.dId}){
                       var pos=document.getElementById("dId");
                       pos.options.length=0;
                       <c:forEach items="${departments.positions}" var="pos1">
                         var option=document.createElement("option");
                         option.innerHTML="${pos1.pName}";
                       option.value=${pos1.pId};
                       pos.append(option);
                       </c:forEach>
                   }
                </c:forEach>

                <%--  if(did==${positions.dId}){
                            //创建option来存储遍历的对象的name和value
                            var option=document.createElement("option");
                            option.innerHTML=${positions.pName};
                            option.value=${positions.pId};
                            // 将创建的option存储到节点片段中
                            frag.append(option);
                        }--%>
            }
    </script>
</head>
<body>
<div id="div1">
    <h1>添加招聘信息</h1>
    <form action="addInformation" method="post" name="form1">
        标　　题：<input type="text" name="recTitle" required="required"><br>
        部门：<select name="dId"  onchange="select_change(this)">
        <c:if test="${!empty sessionScope.departments}">
            <c:forEach items="${sessionScope.departments}" var="departments">
                <option name="dId" value=" ${departments.dId}"> ${departments.dName}</option>
            </c:forEach>
        </c:if>
    </select>
        职位：<select name="pId" id="dId">
        <c:if test="${!empty sessionScope.departments}">
            <c:forEach items="${sessionScope.departments[0].positions}" var="positions">
                <option name="dId" value=" ${positions.pId}"> ${positions.pName}</option>
            </c:forEach>
        </c:if>
    </select><br>
        信息简述：<br>
        <textarea name="recContent" style="width:200px;height:80px;" required="required"></textarea><br>

        <input type="submit" value="添加">
        <input type="reset" value="重置">
    </form>
    <a href="skipRecruit">返回</a>
</div>
</body>
</html>
