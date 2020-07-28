<%@ page contentType="text/html; utf-8" language="java" pageEncoding="utf-8" %>
<html>
<title>登录</title>
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
        border-bottom-color: rgb(251, 255, 248);
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
        background: #fbfff8;
    }
    .input{
        width: content-box;
    }
</style>
<body>
<script>
    function validate() {

        //验证用户输入的账号或密码是否为空
        var num = document.form.num.value;
        var pwd = document.form.pwd.value;


        if (num == "") {
            window.alert("您输入的账号为空，请重新输入！");
            document.form.account.focus();
            return;
        } else if (pwd == "") {
            window.alert("您输入的密码为空，请重新输入！");
            document.form.pwd.focus();
            return;
        } else {
            document.form.submit();
        }
    }
</script>
<%--<form name="form" action="">
    账号：<input type="text" name="account"><br>
    密码：<input type="password" name="pwd"><br>
    <input type="button" onclick="validate()" value="提交"><br>
</form>
&lt;%&ndash;<div id="resultDiv"></div>&ndash;%&gt;

<h2>测试查询寝室信息</h2>
<form name="form" action="Login/dormitoryLogin">
    id：<input type="text" name="id"><br>
    从属id：<input type="text" name="sushe_id"><br>
    编号：<input type="password" name="num"><br>
    <input type="submit" value="登录"><br>
</form>--%>
<table align="center">
    <caption>管理员登录</caption>
    <tr></tr><tr></tr>
    <form name="form" action="G_AdminLogin" method="post">
    <tr><td>账号：</td><td colspan="2"><input type="text" name="num"></td></tr><tr></tr>
    <tr><td>密码：</td><td colspan="2"><input type="password" name="pwd"></td></tr>
        <tr><td colspan="2"></td><td><input class="input" type="button" onclick="validate()" value="登录"></td></tr><br>
</form></table>
</body>
</html>
