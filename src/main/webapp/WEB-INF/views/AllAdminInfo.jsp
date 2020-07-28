<%@ page import="java.util.List" %>
<%@ page import="beans.susheAndDm" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/18
  Time: 21:32
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
            width:40%;
            height: 35%;
            border-bottom-color: rgb(230, 189, 189);
        }


        /* Padding and font style */
        table td, table th {
            padding: 5px 10px;
            font-size: 12px;
            font-family: Verdana;
            color: rgb(177, 106, 104);
        }

        /* Alternating background colors */
        table tr:nth-child(even) {
            background: rgb(240, 213, 212)
        }
        table tr:nth-child(odd) {
            background: #FFF
        }
        .header{
            color: lightpink;
            padding: 20px;
            font-size: 28px;
            font-family: 楷体;
            text-align: center;
        }
    </style>
</head>
<body>
<h2 class="header" align="center">寝室及宿舍的信息</h2>

<%
    List<susheAndDm> adminList = (List<susheAndDm>) request.getSession().getAttribute("adminList");
//    out.write("<table><tr><td>账号</td><td>姓名</td><td>性别</td><td>管理寝室</td></tr>");
    out.write("<table align=center><tr><td>寝室编号</td><td>所属宿舍id</td><td>所属宿舍编号</td></tr>");
    for (susheAndDm susheAndDm : adminList) {
        out.write("<tr><td>" + susheAndDm.getDnum() + "</td><td>" + susheAndDm.getId()+ "</td>");
        out.write("<td>" + susheAndDm.getSnum() + "</td></tr>");
    }
    out.write("</table>");
%>

</body>
</html>
