<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 唐腾
  Date: 2020/7/16
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>registerpage</title>、
    <style>
        body{
            margin-left: 45%;
            background:  url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1594984391698&di=179a1c09f6d031b927654be80b2a79c1&imgtype=0&src=http%3A%2F%2Fwww.51pptmoban.com%2Fd%2Ffile%2F2012%2F08%2F21%2F4299a7be487f9611e60ee34f86a06f7f.jpg) no-repeat top left ;
            background-size: 100% 100%;
        }
        h1{
            text-algin:center;
            color:black;
            align-content: center;
        }
        p{
            color: dodgerblue;
        }
    </style>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#check").click(function () {
                var account1=$("#a").val();
                var pwd=$("#p").val();
                var name1=$("#n").val();
                var code1=$("#code").val();
                if(account1!=""){
                    if(pwd==""||name1==""){
                        alert("您有未输入的信息");
                    }
                    else{
                        if(code1==""){
                            alert("请先提交注册码");
                        }
                        else {
                            $("form").submit();
                        }
                    }
                }
                else {
                    alert("您有未输入的信息");
                }
            })
        })
    </script>
</head>
<body>
<div style="border-color: blue;align-content: center">
    <h1>管理员注册</h1>
    <form action="${pageContext.request.contextPath}/home/ValidateUser" method="post" >
        账号：<input type="text" id="a" name="account" placeholder="输入账号"><br>
        密码：<input type="password" id="p" name="password" placeholder="输入密码"><br>
        姓名：<input type="text" name="name" id="n" placeholder="输入姓名" ><br>
        性别：<input type="radio" value="man" name="sex" checked>男
        <input type="radio" value="woman" name="sex">女<br>
        负责宿舍：<br>
        园区
        <select name="mpid">
            <option value="珙桐">珙桐</option>
            <option value="芙蓉">芙蓉</option>
            <option value="香樟">香樟</option>
            <option value="银杏">银杏</option>
        </select>
        楼号
        <select name="mpnum">
            <option value="A1">A1</option>
            <option value="A2">A2</option>
            <option value="B1">B1</option>
            <option value="B2">B2</option>
        </select><br>
        <input type="button" value="注册" id="check">

    </form>
</div>
<div id="RegistrationCode">
    注册号：
    <input type="text" id="code" placeholder="请输入注册码">
    <input type="button" value="提交注册码" onclick="validate()">
</div>
</body>
<script type="text/javascript">

    function validate() {
        //var xmlHttp=false;
        var code1=document.getElementById("code").value;
        var xmlHttp=false;
        xmlHttp=new XMLHttpRequest();
        var url="/sushe3/home/ValidateCode?code="+code1;
        xmlHttp.open("GET",url,true);
        xmlHttp.onreadystatechange=function () {
            if(xmlHttp.readyState==4){
                RegistrationCode.innerHTML=xmlHttp.responseText;
            }
        }
        xmlHttp.send();
    }
</script>
</html>
