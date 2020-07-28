<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/24
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<style>
    form{
        text-align: center;
    }
</style>
<body>
<form name="doUpdate" action="/sushe3/updateMethod" method="post">
    进行更新的编号：<input name="id" type="text"><br>
    新的名称：<input name="name" type="text"><br>
    新的地址：<input name="address" type="text"><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="提交"><br>
</form>
<a href="../mainPage.jsp">返回</a>
</body>
</html>
