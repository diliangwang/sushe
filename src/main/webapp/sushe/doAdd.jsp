<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/24
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<style>
    form{
        text-align: center;
    }
</style>
<body>
<%--          或者 action="${pageContext.request.contextPath}/addMethod"--%>
<form name="doAdd" action="/sushe3/addMethod" method="post">
    编号：<input name="id" type="text"><br>
    名称：<input name="name" type="text"><br>
    地址：<input name="address" type="text"><br>
    <input type="submit" value="提交"><br>
</form>                                                                               <%--  路径问题仍未能理解，用视频中那样的路径访问不到  --%>
<a href="../mainPage.jsp">返回</a>
</body>
</html>
