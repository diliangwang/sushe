<%@ page import="beans.Manager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        #main {
            width: 600px;
            margin: 10px auto;
        }
    </style>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript">
        function refresh(){
            location.href="showAllInfo";
        }
    </script>
</head>
<body>
<%List<Manager> list=(List<Manager>)request.getAttribute("list"); %>
<div in="main">
    <table class="table table-striped table-bordered">
        <tr>
            <th>账号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>管理区域</th>
            <th>管理楼号</th>
        </tr>
        <%for (int i=0;i<list.size();i++){%>
        <tr>
            <td><%=list.get(i).getAccount()%></td>
            <td><%=list.get(i).getName()%></td>
            <td><%=list.get(i).getSex()%></td>
            <td><%=list.get(i).getMpid()%></td>
            <td><%=list.get(i).getMpnum()%></td>
        </tr>
        <%}%>
    </table>
    <input type="button" value="刷新" class="btn btn-primary" onclick="refresh()">
</div>
</body>
</html>
