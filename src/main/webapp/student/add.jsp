<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加学生信息</title>
    <link rel="stylesheet" type="text/css" href="..\static\css\select.css">

    <script src="..\static\js\func.js"></script>


</head>

<body>
    <div class="div">
       <h3>学生信息添加</h3>
        <form method="post" id="form1" action="../stu/add">
            学生id:<input type="text" name="StudentId"><br>
            学生学号:<input type="text" name="StudentNum"><br>
            学生姓名:<input type="text" name="StudentName"><br>
            学生性别:<input type="text" name="StudentSex"><br>
            学生从属寝室id:<input type="text" name="StudentDomiId"><br>
            <input type="submit"  value="确认提交"> &nbsp; <input type="button" onclick="reloadall()" value="重置信息"><br>
            <a href="../student.jsp">返回学生管理主页面</a>
        </form>
    </div>
</body>
</html>
