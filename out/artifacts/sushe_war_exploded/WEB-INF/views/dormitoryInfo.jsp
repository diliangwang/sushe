<%@ page import="beans.G_Admin" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Dormitory" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/18
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
            background: rgb(150, 231, 255)
        }
        table tr:nth-child(odd) {
            background: #FFF
        }
        .header{
            color: #ffb6c1;
            padding: 20px;
            font-size: 28px;
            font-family: 楷体;
            text-align: center;
        }
    </style>

</head>
<body>
<h3 class="header">管理寝室</h3>
<table align="center"><tr align="center"><td>寝室id</td><td>寝室编号</td><td>所属宿舍id</td><td>操作</td><td>操作</td></tr>
<%
    List<Dormitory> dormitoryList = (List<Dormitory>) request.getSession().getAttribute("dormitoryList");
//    out.write("<table><tr><td>账号</td><td>姓名</td><td>性别</td><td>管理寝室</td></tr>");
    if(dormitoryList.size()!=0){
        for (Dormitory dormitory : dormitoryList) {%>
            <tr align="center"><td><%=dormitory.getId()%></td><td><%=dormitory.getNum()%></td>
            <td><%=dormitory.getSushe_id()%></td>
            <td><a href="/sushe/refreshDormitory.jsp?id=<%=dormitory.getId()%>&&num=<%=dormitory.getNum()%>&&sushe_id=<%=dormitory.getSushe_id()%>">修改</a></td>
            <td><a href="dormitoryDelete?num=<%=dormitory.getNum()%>">删除</a></td><tr>
        <%}
    }else {
        out.write("没有任何记录！");
    }
        out.write("</table>");
%>
</body>
</html>
