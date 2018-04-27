<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fom" uri="http://java.sun.com/jstl/fmt_rt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <style>
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
        /*超链接去除下划线 带边框*/
        a{
            display: inline-block;
            margin-left: 40px;
            border: 1px solid black;
            text-decoration: none;
        }
    </style>
    <script type="text/javascript">

        function dep_pos(dId) {
            <c:forEach items="${sessionScope.allDepartments}" var="d">
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
    </script>
</head>
<body>



  <div>
      <table>
          <tr>
              <th>员工编号</th>
              <th>员工姓名</th>
              <th>联系电话</th>
              <th>性别</th>
              <th>年龄</th>
              <th>任职状态</th>
              <th>部门名称</th>
              <th>职位名称</th>
              <th>入职日期</th>
              <th></th>
          </tr>

              <form action="updateEmployee" method="post">
                  <tr>
                      <td>${sessionScope.oneEmployee.eId}</td>
                      <td>${sessionScope.oneEmployee.eName}</td>
                      <td>${sessionScope.oneEmployee.ePhone}</td>
                      <td>${sessionScope.oneEmployee.eSex}</td>
                      <td>${sessionScope.oneEmployee.eAge}</td>
                      <td>${sessionScope.oneEmployee.eState}</td>
                      <td>
                          <select name="eDid" onchange="dep_pos(this)">
                              <c:forEach items="${sessionScope.allDepartments}" var="d">
                                 <c:choose>
                                     <c:when test="${sessionScope.oneEmployee.eDid==d.dId}">
                                         <option name="eDid" value="${d.dId}" selected="selected">${d.dName}</option>
                                     </c:when>
                                     <c:otherwise >
                                         <option name="eDid" value="${d.dId}">${d.dName}</option>
                                     </c:otherwise>
                                 </c:choose>
                              </c:forEach>
                          </select>
                      </td>
                      <td>
                          <select name="ePid" id="pId" onchange="pp(this)">
                              <c:forEach items="${sessionScope.allDepartments}" var="d">
                                  <c:if test="${sessionScope.oneEmployee.eDid==d.dId}">
                                      <c:forEach var="p" items="${d.positions}">
                                          <c:choose>
                                              <c:when test="${sessionScope.oneEmployee.ePid==p.pId}">
                                                  <option name="ePid" value="${p.pId}" selected="selected">${p.pName}</option>
                                              </c:when>
                                              <c:otherwise >
                                                  <option name="ePid" value="${p.pId}">${p.pName}</option>
                                              </c:otherwise>
                                          </c:choose>
                                      </c:forEach>
                                  </c:if>
                              </c:forEach>
                          </select>
                      </td>
                      <td><fom:formatDate value="${sessionScope.oneEmployee.eJoinDate}" type="Date" pattern="yyyy-MM-dd hh:mm:ss"/> </td>
                      <input type="hidden" name="eId" value="${sessionScope.oneEmployee.eId}">
                      <input type="hidden" name="pow" value="1">
                      <td><input type="submit" value="调岗"></td>
                  </tr>
              </form>


      </table>
  </div>
  <a href="skipSelectEmployee">返回</a>
</body>
</html>
