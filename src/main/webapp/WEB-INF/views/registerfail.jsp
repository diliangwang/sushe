<%--
  Created by IntelliJ IDEA.
  User: 唐腾
  Date: 2020/7/22
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerfailpage</title>
</head>
<body>
注册失败,三秒后回到注册页面。。。

<script type="text/javascript">
    window.setTimeout("warninfo()","3000");
    function warninfo() {
        window.location.href="index";
    }
</script>
</body>
</html>
