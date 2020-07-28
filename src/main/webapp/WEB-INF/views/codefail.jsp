<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
对不起请重新验证
<%
    Boolean m=false;
    session.setAttribute("mark",m);
    out.print("请刷新页面，重新输入注册码");
%>
</body>
</html>
