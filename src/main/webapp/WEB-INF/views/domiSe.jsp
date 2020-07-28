<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>按照寝室id查询</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="..\static\css\view.css">

</head>
<body>
<script type="text/javascript">
    var length =${requestScope.StudentDomiId.size()};
    var i =0;
    if(length === 1){
        var id = '${requestScope.StudentDomiId.get(0).getStudentId()}';
        var num = '${requestScope.StudentDomiId.get(0).getStudentNum()}';
        var name = '${requestScope.StudentDomiId.get(0).getStudentName()}';
        var sex = '${requestScope.StudentDomiId.get(0).getStudentSex()}';
        var domid = '${requestScope.StudentDomiId.get(0).getStudentDomiId()}';
        document.write('<div class="div" ><table border="1"><tr><th>id</th><th>学号</th><th>姓名</th><th>性别</th><th>寝室id</th>');
        document.write('<tr><td>'+ id +'</td>');
        document.write('<td>'+num+"</td>");
        document.write('<td>'+name+"</td>");
        document.write('<td>'+sex+"</td>");
        document.write('<td>'+domid+"</td></tr></table></div>");
    }
    else if(length ==2){
        var id = '${requestScope.StudentDomiId.get(0).getStudentId()}';
        var num = '${requestScope.StudentDomiId.get(0).getStudentNum()}';
        var name = '${requestScope.StudentDomiId.get(0).getStudentName()}';
        var sex = '${requestScope.StudentDomiId.get(0).getStudentSex()}';
        var domid = '${requestScope.StudentDomiId.get(0).getStudentDomiId()}';
        var id1 = '${requestScope.StudentDomiId.get(1).getStudentId()}';
        var num1 = '${requestScope.StudentDomiId.get(1).getStudentNum()}';
        var name1 = '${requestScope.StudentDomiId.get(1).getStudentName()}';
        var sex1 = '${requestScope.StudentDomiId.get(1).getStudentSex()}';
        var domid1 = '${requestScope.StudentDomiId.get(1).getStudentDomiId()}';
        document.write('<div class="div" ><table border="1"><tr><th>id</th><th>学号</th><th>姓名</th><th>性别</th><th>寝室id</th>');
        document.write('<tr><td>'+ id +'</td>');
        document.write('<td>'+num+"</td>");
        document.write('<td>'+name+"</td>");
        document.write('<td>'+sex+"</td>");
        document.write('<td>'+domid+"</td></tr>")
        document.write('<tr><td>'+ id1 +'</td>');
        document.write('<td>'+num1+"</td>");
        document.write('<td>'+name1+"</td>");
        document.write('<td>'+sex1+"</td>");
        document.write('<td>'+domid1+ "</td></tr></table></div>");
    }

</script>

<a href="../student/domiselect.jsp">继续查询</a> &nbsp;
<a href="../student.jsp">返回学生管理主页面</a>
</body>
</html>
