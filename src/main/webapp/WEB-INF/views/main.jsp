<%@ page import="beans.G_Admin" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
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
            background: url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1594984391698&di=179a1c09f6d031b927654be80b2a79c1&imgtype=0&src=http%3A%2F%2Fwww.51pptmoban.com%2Fd%2Ffile%2F2012%2F08%2F21%2F4299a7be487f9611e60ee34f86a06f7f.jpg)no-repeat;
            background-size: 100% 100%;
        }
        #a{
            width: 100%;
            height: 5%;
            background-color: #96e7ff;
            border: black;
        }
    </style>
    <title>mainpage</title>
    <script>
        function loadinfo() {
            var xmlHttp = false;
            xmlHttp = new XMLHttpRequest();
            var url = "showAllInfo" ;
            xmlHttp.open("GET", url, true);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    showInfo.innerHTML = xmlHttp.responseText;
                }
            }
            xmlHttp.send();
        }
    </script>
    <script>
        function queryinfo() {
            var account=document.getElementById("account1").value;
            var xmlHttp = false;
            xmlHttp = new XMLHttpRequest();
            var url = "queryUser?account="+account ;
            xmlHttp.open("GET", url, true);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    query.innerHTML = xmlHttp.responseText;
                }
            }
            xmlHttp.send();
        }
    </script>
    <script>
        function addpage() {
            location.href="add";
        }
    </script>
    <script>
        function changepage() {
            location.href="change";
        }
    </script>
    <script>
        function deletepage() {
            location.href="delete";
        }
    </script>
</head>
<body>
<%
//    G_Admin g_admin = (G_Admin) request.getSession().getAttribute("g_admin");
%>
<table id="a" style="table-layout: fixed">
    <tr><td style="word-wrap: break-word"><a href="/sushe3/sushe.jsp">宿舍管理</a></td>
        <td><a href="/sushe3/dormitory.jsp">寝室管理</a></td>
        <td><a href="/sushe3/student.jsp">学生管理</a></td>
<%--        <td><a href="/sushe3/addDormitory.jsp">添加寝室</a></td></tr>--%>
</table>
<div id="showInfo">
    显示用户信息
    <input type="button" value="查看所有信息" onclick="loadinfo()">
</div>
<div id="query">
    查询用户<br>
    输入账号<input type="text" id="account1">
    <input type="button" value="查询" onclick="queryinfo()">
</div>
<div id="otherstep">
    其他操作<br>
    <input type="button" value="添加" onclick="addpage()">
    <input type="button" value="修改" onclick="changepage()">
    <input type="button" value="delete" onclick="deletepage()">
    <a href="/sushe3/student.jsp">学生管理</a>
</div>
</body>
</html>
