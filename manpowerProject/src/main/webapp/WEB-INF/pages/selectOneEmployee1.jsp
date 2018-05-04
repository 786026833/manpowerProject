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
            margin:0 auto;
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
            function  pp() {
                document.getElementById("input2").removeAttribute("disabled");
                var name = prompt("离职原因：")
                if (name != null && name != "") {
                    document.getElementById("input1").value = "离职--原因：" + name;
                }
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
              <tr>
                  <td>${sessionScope.oneEmployee.eId}</td>
                  <td>${sessionScope.oneEmployee.eName}</td>
                  <td>${sessionScope.oneEmployee.ePhone}</td>
                  <td>${sessionScope.oneEmployee.eSex}</td>
                  <td>${sessionScope.oneEmployee.eAge}</td>
                  <td>${sessionScope.oneEmployee.eState}</td>
                  <td>${sessionScope.oneEmployee.eDid}</td>
                  <td>${sessionScope.oneEmployee.ePid}</td>
                  <td><fom:formatDate value="${sessionScope.oneEmployee.eJoinDate}" type="Date" pattern="yyyy-MM-dd hh:mm:ss"/> </td>
                  <td>
                      <form action="updateEmployee" method="post">
                          <input id="input1" type="hidden" name="eState" value="${sessionScope.oneEmployee.eState}">
                          <input type="hidden" name="eId" value="${sessionScope.oneEmployee.eId}">
                          <input type="hidden" name="pow" value="3">
                          <input  type="button" value="离职"  onclick="pp()">
                          <input id="input2" type="submit" value="确定" disabled="disabled">
                       </form>
                  </td>
              </tr>



      </table>
  </div>
  <a href="skipSelectEmployee">返回</a>
</body>
</html>
