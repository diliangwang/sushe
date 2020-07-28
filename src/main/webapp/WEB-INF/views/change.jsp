<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>changepage</title>
</head>
<body>
<h1>请输入你所要修改的信息</h1>
<form action="${pageContext.request.contextPath}/home/changeInfo">
    账号：<input type="text" id="a" name="account" placeholder="输入账号"><br>
    密码：<input type="password" id="p" name="password" placeholder="输入密码"><br>
    姓名：<input type="text" name="name" id="n" placeholder="输入姓名" ><br>
    性别：<input type="radio" value="man" name="sex" checked>男
    <input type="radio" value="woman" name="sex">女<br>
    负责宿舍：<br>
    园区
    <select name="mpid">
        <option value="珙桐">珙桐</option>
        <option value="芙蓉">芙蓉</option>
        <option value="香樟">香樟</option>
        <option value="银杏">银杏</option>
    </select>
    楼号
    <select name="mpnum">
        <option value="A1">A1</option>
        <option value="A2">A2</option>
        <option value="B1">B1</option>
        <option value="B2">B2</option>
    </select><br>
    <input type="submit" value="修改" >
</form>
</body>
</html>
