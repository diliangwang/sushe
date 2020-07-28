<%@ page import="java.util.List" %>
<%@ page import="beans.Dormitory" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input.text{
            width: border-box;
            text-align:left;
        }
        table{
            text-align: center;
            width: content-box;
            font-family: 宋体;
            border-color: black;
        }
        table td,table th{
            border-color: black;
            width: 100px;
            margin-top: 3px;
            margin-left: 2px;
        }
        .header{
            padding: 20px;
            color: darkgoldenrod;
            alignment: center;
            text-align: center;
        }
    </style>
</head>
<body>
<%
    String id = request.getParameter("id");
    String num = request.getParameter("num");
    String sushe_id = request.getParameter("sushe_id");
%>
        <h3 class="header">修改宿舍信息</h3>
<table align="center">
        <form action="dormitoryRefresh" name="form">
        <tr><td>寝室编号：</td><td><input type="text" name="num"></td></tr>
        <tr><td>所属宿舍ID：</td><td><input type="text" name="sushe_id"></td></tr>
        <input class="text" type="hidden" id="num1" value="<%=num%>"><br>
        <input class="text" type="hidden" id="sushe_id1" value="<%=sushe_id%>">
        <input class="text" type="hidden" name="id" value="<%=id%>">
        <tr><td align="right"><input type="submit" value="提交"></td><td align="left"><input type="reset" value="重置"></td></tr>
        </form>
</table>


<script>
    document.form.num.value=document.getElementById("num1").value;
    document.form.sushe_id.value=document.getElementById("sushe_id1").value;

</script>
</body>
</html>
