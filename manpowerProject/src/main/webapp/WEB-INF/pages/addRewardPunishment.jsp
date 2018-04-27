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
                    if(pId.value==${p.employees}){
                        var pe =document.getElementById("eId");
                        pe.options.length=0;
                        <c:forEach items="${p.employees}"  var="p">
                            var option=document.createElement("option");
                            option.innerHTML="${p.pName}";
                            option.value=${p.pId};
                            pe.append(option);
                        </c:forEach>
                    }
                </c:forEach>
           </c:forEach>
        }
    </script>
</head>
<body>
<div>
    <form action="" method="post">
        <select name="eDid" onchange="dep_pos(this)">
            <c:forEach items="${departments}" var="d">
                <option name="dId" value="${d.dId}" >${d.dName}</option>
            </c:forEach>
        </select>
        <select name="ePid" id="pId" onchange="pp(this)">
                <c:forEach items="${departments[0].positions}" var="p">
                            <option name="pId" value="${p.pId}">${p.pName}</option>
                </c:forEach>
        </select>
        <select name="eId" id="eId" >
         <c:forEach items="${departments[0].positions}" var="p">
            <c:if test="${!empty departments[0].positions[0].employees}">
                <c:forEach items="${departments[0].positions[0].employees}" var="e">
                    <option name="eId" value="${e.eId}">${e.eName}</option>
                </c:forEach>
            </c:if>
         </c:forEach>
        </select>
        原因:<input type="text" >


    </form>

</div>
<a href="skipRewardPunishment">返回</a>
</body>
</html>
