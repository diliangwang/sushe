<%--
  Created by IntelliJ IDEA.
  User: 唐腾
  Date: 2020/7/22
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registersuccesspage</title>
</head>
<body>
注册成功,三秒后跳转到登录页面。。。
<script type="text/javascript">
    window.setTimeout("warninfo()","3000");
    function warninfo() {
        window.location.href="main";
    }
</script>
</body>
</html>
