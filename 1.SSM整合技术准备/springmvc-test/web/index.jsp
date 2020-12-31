<%--
  Created by IntelliJ IDEA.
  User: SJKF1
  Date: 2020/12/28
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="user/registe"  method="post">

    名称 ：<input type="text" name="username" value=""><br/>
    账号： <input type="text" name="password" value=""><br/>
    年龄： <input type="text" name="age" value=""><br/>
    <input type="submit" value="提交">
</form>

<form action="/user/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>
</body>
</html>
