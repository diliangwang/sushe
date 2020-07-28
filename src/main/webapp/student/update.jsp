<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
    <link rel="stylesheet" type="text/css" href="..\static\css\select.css">
    <script type="text/javascript">

    </script>
</head>
<body>
    <div>
        <h3>学生信息修改</h3>
        <form method="post" id="form1" action="../stu/update">
            输入要修改的学生的学号:<input type="text" name="StudentNum"><br>
            输入要修改的学生的姓名:<input type="text" name="StudentName"><br>
            输入修改后学生的学生id:<input type="text" name="StudentId"><br>
            输入修改后学生的学生从属寝室id:<input type="text" name="StudentDomiId"><br>
            <input type="submit" value="确认修改" > &nbsp; <input type="button" value="清空" onclick="">
            <a href="../student.jsp">返回学生管理主页面</a>
        </form>
    </div>

</body>
</html>
