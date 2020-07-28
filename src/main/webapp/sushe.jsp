<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
    <link rel="stylesheet" type="text/css" href="static\css\index.css">
</head>
<body>
<h2>主页面</h2>
<a href="../mainPage.jsp">返回</a>
<a href="sushe/doAdd.jsp">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="sushe/doDelete.jsp">删除</a>&nbsp;&nbsp;
&nbsp;&nbsp;<a href="sushe/doUpdate.jsp">更改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="sushe/doQuery.jsp">查询</a>
<hr>
<%
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    String url = "jdbc:MySQL://localhost:3306/test?serverTimezone=Asia/Shanghai "; //指向数据库
    String username = "root";  //数据库用户名
    String password = "12345678";  //数据库用户密码
    String sql = "select * from dorm";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");  //加载数据库驱动
        conn = DriverManager.getConnection(url, username, password);
        if (conn != null) {
            out.print("数据库连接成功..." + "<br>");
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } else {
            out.print("数据库连接失败！");
        }
    }
    catch(Exception e){
        out.print("数据库连接异常！");
    }
%>

<table align="center" border="1" cellspacing="0" cellpadding="10" width="60%">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>地址</th>
    </tr>
    <%
        while(true)
        {
            try {
                if (rs != null && !rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }%>
    <tr>
        <td><%=rs.getString("id")%></td>
        <td><%=rs.getString("name") %></td>
        <td><%=rs.getString("address")%></td>
    </tr>
    <%}
    %>
</table>
<%
    try {
        if(rs!=null) {
            rs.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    try {
        if(pstmt!=null) {
            pstmt.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    try {
        if(conn!=null) {
            conn.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>
