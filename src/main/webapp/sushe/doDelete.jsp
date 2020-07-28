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
    <title>Delete</title>
</head>
<style>
    form{
        text-align: center;
    }
</style>
<body>
<form name="doAdd" action="/sushe3/deleteMethod" method="post">
    输入要删除的编号：<input name="i" type="text">
    <input type="submit" value="提交">
</form>
<a href="../mainPage.jsp">返回</a>
</body>
</html>
