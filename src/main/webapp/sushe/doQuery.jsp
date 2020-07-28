<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/24
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Query</title>
</head>
<style>
    form{
        text-align: center;
    }
    p{
        text-align: center;
    }
</style>
<body>
<form name="doQuery" action="/sushe3/queryMethod" method="post">
    输入要查询的编号：<input name="i" type="text">
    <input type="submit" value="提交">
</form>
<table align="center">
    <th>结果如下:</th>
    <tr><td>编号：</td><td>${result.id}</td></tr>
    <tr><td>名称：</td><td>${result.name}</td></tr>
    <tr><td>地址：</td><td>${result.address}</td></tr>
</table>
<a href="../mainPage.jsp">返回</a>
</body>
</html>
