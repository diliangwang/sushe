<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>寝室id查询</title>
    <style>
        div{
            background-image: url(../static/imgs/2.jpg);
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <form method="post" id="form1" action="../stu/domiSe">
        输入寝室id:<input type="text" name="StudentDomiId"><br>
        <input type="submit" value="确认查询"><br>
        <a href="../student.jsp">返回学生管理主页面</a>
    </form>
</div>

</body>
</html>
