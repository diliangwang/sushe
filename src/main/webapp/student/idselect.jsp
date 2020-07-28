<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过学生id查询</title>
    <style>
        div{
            background-image: url(../static/imgs/2.jpg);
            text-align: center;
        }
    </style>
    <script>

    </script>
</head>
<body>
    <div>
        <form method="post" id="form1" action="../stu/idSe">
            请输入学生id:<input type="text" name="StudentId"><br>
            <input type="submit" value="查询"> <br>
            <a href="../student.jsp">返回学生管理主页面</a>
        </form>
    </div>
</body>
</html>
