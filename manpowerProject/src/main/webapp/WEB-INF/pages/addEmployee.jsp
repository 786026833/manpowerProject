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
            width: 500px;
            height:400px;
            background-color: aqua;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function init(){
            function select_change(did)
            {
                var pos=document.form1.T_POSITION;
                //设置节点片段来存储新增的option节点
                var frag=document.createDocumentFragment();
                <c:if test="${!empty sessionScope.allPositions}">
                    <c:forEach items="${sessionScope.allPositions}" var="positions">
                          <c:if test="${positions.dId==did}">
                                var option=document.createElement("option");
                                option.innerHTML=${positions.pName};
                                option.value=${positions.pId};
                                frag.append(option);
                          </c:if>
              <%--  if(did==${positions.dId}){
                          //创建option来存储遍历的对象的name和value
                          var option=document.createElement("option");
                          option.innerHTML=${positions.pName};
                          option.value=${positions.pId};
                          // 将创建的option存储到节点片段中
                          frag.append(option);
                      }--%>
                     </c:forEach>
                </c:if>
                pos.append(frag);
            }
        }
    </script>
</head>
<body>
   <div id="div1" onload="init()">
       <form action="addEmployee" method="post" name="form1">
           <h1>员工录入表</h1>
           员工姓名：<input type="text" name="eName" value="${sessionScope.addResume.rName}"><br>
           员工密码：<input type="text" name="ePass" value="${sessionScope.addResume.rName}"><br>
           联系电话：<input type="text" name="ePhone" value="${sessionScope.addResume.rPhone}"><br>
           性　　别：<input type="text" name="eSex" value="${sessionScope.addResume.rSex}"><br>
           年　　龄：<input type="text" name="eAge" value="${sessionScope.addResume.rAge}"><br>
           在职状态：<input type="text" name="eState" value="试用期"><br>
           职位选择：
           部门：<select name="T_DEPARTMENT"  onchange="select_change(this.valueOf())">
              <c:if test="${!empty sessionScope.allDepartments}">
               <c:forEach items="${sessionScope.allDepartments}" var="departments">
                   <option name="T_DEPARTMENT" value=" ${departments.dId}"> ${departments.dName}</option>
               </c:forEach>
             </c:if>
            </select>
           职位：<select name="T_POSITION"></select><br>

           <input type="submit" value="添加">  <input type="reset" value="重置">
       </form>
   </div>
   <a href="skipResumeDd">返回</a>
</body>
</html>
