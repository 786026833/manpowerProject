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

</head>
<body>
  <div>
      <span>${update}</span>
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
              <th></th>
              <th></th>
          </tr>
          <c:forEach items="${sessionScope.allEmployees}" var="e">

                  <tr>
                      <td>${e.eId}</td>
                      <td>${e.eName}</td>
                      <td>${e.ePhone}</td>
                      <td>${e.eSex}</td>
                      <td>${e.eAge}</td>
                      <td>${e.eState}</td>
                      <td>
                          <select name="dId" onchange="dep_pos(this)">
                              <c:forEach items="${sessionScope.allDepartments}" var="d">
                                 <c:choose>
                                     <c:when test="${e.eDid==d.dId}">
                                         <option value="${d.dId}" selected="selected">${d.dName}</option>
                                     </c:when>
                                    <%-- <c:otherwise >
                                         <option value="${d.dId}">${d.dName}</option>
                                     </c:otherwise>--%>
                                 </c:choose>
                              </c:forEach>
                          </select>
                      </td>
                      <td>
                          <select name="pId" id="pId">
                              <c:forEach items="${sessionScope.allDepartments}" var="d">
                                  <c:if test="${e.eDid==d.dId}">
                                      <c:forEach var="p" items="${d.positions}">
                                          <c:choose>
                                              <c:when test="${e.ePid==p.pId}">
                                                  <option value="${p.pId}" selected="selected">${p.pName}</option>
                                              </c:when>
                                              <%--<c:otherwise >
                                                  <option value="${p.pId}">${p.pName}</option>
                                              </c:otherwise>--%>
                                          </c:choose>
                                      </c:forEach>
                                  </c:if>
                              </c:forEach>
                          </select>
                      </td>
                      <td>
                      <fom:formatDate value="${e.eJoinDate}" type="Date" pattern="yyyy-MM-dd hh:mm:ss"/>
                      </td>
                      <c:choose>
                          <c:when test="${e.ePid==0&&e.eDid==0}">
                              <td></td>
                              <td></td>
                              <td></td>
                          </c:when>
                          <c:otherwise>
                              <td><a href="selectOneEmployee?eId=${e.eId}&pow=1">调岗</a></td>
                              <td><a href="updateEmployee?eId=${e.eId}&eJoinDate=${e.eJoinDate}&pow=2">转正</a></td>
                              <td><a href="selectOneEmployee1?eId=${e.eId}">离职</a></td>
                          </c:otherwise>
                      </c:choose>

                  <%--  <td><form action="updateEmployee" method="post">
                          <input id="input1" type="hidden" name="eState" value="${e.eState}">
                          <input type="hidden" name="eId" value="${e.eId}">
                          <input type="hidden" name="pow" value="3">
                          <input  type="button" value="离职"  onclick="pp()">
                          <input id="input2" type="submit" value="确定" disabled="disabled">
                      </form>--%>
                      </td>
                  </tr>

          </c:forEach>
      </table>
  </div>
  <a href="skipAdm_empl">返回</a>
</body>
</html>
