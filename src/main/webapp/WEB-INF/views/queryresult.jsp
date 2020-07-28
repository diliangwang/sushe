<%@ page import="beans.Manager" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>queryresultpage</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%Manager manager=(Manager)request.getAttribute("manager");%>
<table class="table table-striped table-bordered">
    <tr>
        <th>账号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>密码</th>
        <th>管理区域</th>
        <th>管理楼号</th>
    </tr>
    <tr>
        <td><%=manager.getAccount()%></td>
        <td><%=manager.getName()%></td>
        <td><%=manager.getSex()%></td>
        <td><%=manager.getPassword()%></td>
        <td><%=manager.getMpid()%></td>
        <td><%=manager.getMpnum()%></td>
    </tr>
</table>
</body>
</html>
