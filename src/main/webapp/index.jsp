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
        /*        border-bottom-width: 1px;
                border-bottom-style: solid;*/
        width:30%;
        height: 30%;
        /*border-bottom-color: rgb(251, 255, 248);*/
    }


    /* Padding and font style */
    table td, table th {
        padding: 5px 10px;
        font-size: 12px;
        font-family: Verdana;
        color: rgb(177, 106, 104);
    }

    /* Alternating background colors */
    /*    table tr:nth-child(even) {
            background: rgb(251, 255, 248)
        }
        table tr:nth-child(odd) {
            background: #fbfff8;
        }*/
    .input{
        width: content-box;
    }
    body{
        /*        position:fixed;
                top: 0;
                left: 0;
                width:100%;
                height:100%;
                min-width: 1000px;
                z-index:-10;
                zoom: 1;
                background-color: #fff;
                background-repeat: no-repeat;
                background-size: cover;
                -webkit-background-size: cover;
                -o-background-size: cover;
                background-position: center 0;*/
        background: url(imgs/timg.jpg) no-repeat ;
        background-size: 100% 100%;
    }
    #register{
        text-align: center;
        font-size: 12px;
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
<table align="center" >
    <caption>欢迎来到宿舍管理系统</caption>
    <tr></tr><tr></tr>
    <form name="form" action="G_AdminLogin" method="post">
        <tr><td>账号：</td><td colspan="2"><input type="text" name="num"></td></tr>
        <tr><td>密码：</td><td colspan="2"><input type="password" name="pwd"></td></tr>
        <tr><td colspan="2"></td><td><input class="input" type="button" onclick="validate()" value="登录"></td></tr><br>
    </form></table>
<div id="register">还没注册？点我<a href="register.jsp">注册</a></div>
</body>
</html>
