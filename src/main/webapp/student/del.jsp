<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生信息</title>
    <link rel="stylesheet" type="text/css" href="..\static\css\select.css">
    <script type="text/javascript">


    </script>
</head>
<body>
<div>
    <h3>学生信息删除/h3>
    <form method="post" id="form1" action="../stu/del">
        请输入学生学号：<input type="text" name="StudentNum"><br>
        请输入学生姓名：<input type="text" name="StudentName"><br>
        <input type="submit"  value="确认删除"> &nbsp; <input type="button" onclick="" value="重置"><br>
        <a href="../student.jsp">返回学生管理主页面</a>
    </form>
</div>

</body>
</html>
