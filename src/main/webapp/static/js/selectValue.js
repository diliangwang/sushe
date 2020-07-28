var id = '${requestScope.StudentId.get(0).getStudentId()}';
var num = '${requestScope.StudentId.get(0).getStudentNum()}';
var name = '${requestScope.StudentId.get(0).getStudentName()}';
var sex = '${requestScope.StudentId.get(0).getStudentSex()}';
var domid = '${requestScope.StudentId.get(0).getStudentDomiId()}';
if('${requestScope.StudentId.get(1)}' == null){

}
else{
    var id1 = '${requestScope.StudentId.get(1).getStudentId()}';
    var num1 = '${requestScope.StudentId.get(1).getStudentNum()}';
    var name1 = '${requestScope.StudentId.get(1).getStudentName()}';
    var sex1 = '${requestScope.StudentId.get(1).getStudentSex()}';
    var domid1 = '${requestScope.StudentId.get(1).getStudentDomiId()}';
}



document.write('<div class="div" ><table border="1"><tr><th>id</th><th>学号</th><th>姓名</th><th>性别</th><th>寝室id</th>');
document.write('<tr><td>'+ id +'</td>');
document.write('<td>'+num+"</td>");
document.write('<td>'+name+"</td>");
document.write('<td>'+sex+"</td>");
document.write('<td>'+domid+"</td></tr></table></div>");
document.write('<tr><td>'+ id1 +'</td>');
document.write('<td>'+num1+"</td>");
document.write('<td>'+name1+"</td>");
document.write('<td>'+sex1+"</td>");
document.write('<td>'+domid1+"</td></tr></table></div>");