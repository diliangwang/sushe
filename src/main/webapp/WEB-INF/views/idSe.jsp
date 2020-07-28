<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <title>按照id查询</title>
    <link rel="stylesheet" type="text/css" href="..\static\css\view.css">

</head>
<body>

<script type="text/javascript">
    try {

    var id = '${requestScope.StudentId.get(0).getStudentId()}';
    var num = '${requestScope.StudentId.get(0).getStudentNum()}';
    var name = '${requestScope.StudentId.get(0).getStudentName()}';
    var sex = '${requestScope.StudentId.get(0).getStudentSex()}';
    var domid = '${requestScope.StudentId.get(0).getStudentDomiId()}';
    }
    catch (e) {

    }
     document.write('<div class="div" ><table border="1"><tr><th>id</th><th>学号</th><th>姓名</th><th>性别</th><th>寝室id</th>');
     document.write('<tr><td>'+ id +'</td>');
     document.write('<td>'+num+"</td>");
     document.write('<td>'+name+"</td>");
     document.write('<td>'+sex+"</td>");
     document.write('<td>'+domid+"</td></tr></table></div>");
</script>

<br>

<a href="../student/idselect.jsp">继续查询</a> &nbsp;
<a href="../student.jsp">返回学生管理主页面</a>
</body>
</html>
