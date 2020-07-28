<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deletefailpage</title>
</head>
<body>
删除失败,可能改用户已经被删除.即将返回主页面。
<script>
    window.setTimeout("warninfo()","2000");
    function warninfo() {
        window.location.href = "main";
    }
</script>
</body>
</html>
