<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/21
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* Border styles */
        table thead, table tr {
            border-top-width: 1px;
            border-top-style: solid;
            border-top-color: rgb(230, 189, 189);
        }
        table {
            border-bottom-width: 1px;
            border-bottom-style: solid;
            width:25%;
            height:20%;
            border-bottom-color: rgb(251, 255, 248);
        }


        /* Padding and font style */
        table td, table th {
            padding: 5px 10px;
            font-size: 12px;
            font-family: Verdana;
            color: rgb(177, 106, 104);
        }
        div{
            font-family: 楷体;
            font-size: 16px;
        }
        h2{
            font-family: 楷体;
        }
    </style>
</head>
<body>
<table>
    <caption>宿舍添加</caption>
<form action="dormitoryAdd" name="form1">
    <tr><td>寝室编号：</td><td><input type="text" name="num"></td></tr>
    <tr><td>寝室所属宿舍：</td><td><input type="text" name="sushe_id"></td></tr>
    <tr><td colspan="2"><input type="submit" value="添加"></td><td></td></tr>
</form></table>
</body>
</html>
