<%@ page contentType="text/html; utf-8" language="java" pageEncoding="utf-8" %>
<html>
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
    //         var xmlHttp = null;
    //         if (window.XMLHttpRequest) {
    //             xmlHttp = new XMLHttpRequest();
    //         } else if (window.ActiveXObject) {
    //             try {
    //                 xmlHttp = new ActiveXObject("Msxm12.XMLHTTP");
    //             } catch (e) {
    //                 try {
    //                     xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    //                 } catch (e) {
    //                     window.alert("该浏览器不支持ajax");
    //                 }
    //             }
    //         }
    //
    //         var url = "/sushe/Login";
    //         xmlHttp.open("post", url, true);
    //         xmlHttp.onreadystatechange = function () {
    //             if (xmlHttp.readyState == 4) {
    //                 resultDiv.innerHTML = xmlHttp.responseText;
    //             } else {
    //                 resultDiv = "正在添加，请稍后...";
    //             }
    //         };
    //         xmlHttp.send();
    //     }
    // }
</script>
<h2>Hello World!</h2>
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

<h2>管理员登录</h2>
<form name="form" action="G_AdminLogin" method="post">
    账号：<input type="text" name="num"><br>
    密码：<input type="password" name="pwd"><br>
    <input type="button" onclick="validate()" value="登录"><br>
</form>
</body>
</html>



