<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理</title>
    <style>
        p{
            text-align: center;;
            font-size:30px;
            font-weight: bold;
        }
        div
        {
            text-align: center ;
            background-image: url(static/imgs/1.jpg);
        }
    </style>
</head>

<body>
<p>学生管理主页</p>
<div>
    <a href="student/add.jsp" >增加学生</a><br>
    <a href="student/del.jsp">删除学生</a><br>
    <a href="student/idselect.jsp" > 通过学生id查询</a><br>
    <a href="student/numselect.jsp" >通过学生学号查询</a><br>
    <a href="student/nameselect.jsp" >通过学生姓名查询</a><br>
    <a href="student/domiselect.jsp" >通过学生从属寝室id查询</a><br>
    <a href="student/update.jsp" >修改学生id和寝室id</a><br>
</div>
</body>
</html>
