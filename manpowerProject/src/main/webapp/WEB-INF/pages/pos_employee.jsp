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
          <c:choose>
              <c:when test="${!empty sessionScope.employees}">
                  <table>
                      <tr>
                          <th>员工编号</th>
                          <th>员工姓名</th>
                          <th>员工密码</th>
                          <th>联系电话</th>
                          <th>性　　别</th>
                          <th>年　　龄</th>
                          <th>任职状态</th>
                          <th>职位编号</th>
                          <th>部门编号</th>
                          <th>入职日期</th>
                      </tr>
                      <c:forEach items="${sessionScope.employees}" var="empl">
                          <tr>
                              <td>${empl.eId}</td>
                              <td>${empl.eName}</td>
                              <td>${empl.ePass}</td>
                              <td>${empl.ePhone}</td>
                              <td>${empl.eSex}</td>
                              <td>${empl.eAge}</td>
                              <td>${empl.eState}</td>
                              <td>${empl.ePid}</td>
                              <td>${empl.eDid}</td>
                              <td><fom:formatDate value="${empl.eJoinDate}" type="Date" pattern="yyyy-MM-dd hh:mm:ss"/> </td>
                          </tr>
                      </c:forEach>
                  </table>
              </c:when>
              <c:otherwise>
                  该职位暂时还没有员工
              </c:otherwise>
          </c:choose>

          <c:if test="${num==1}">
              <a href="skipskipDep_position">返回</a>
          </c:if>
          <c:if test="${num==2}">
              <a href="skipSelectPosition">返回</a>
          </c:if>
      </div>
</body>
</html>
