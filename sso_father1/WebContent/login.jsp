<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<center>
<h1>请登录</h1>
<form action="http://check.x.com:8080/sso_father1/sso/doLogin.action" method="post">
	<span>用户名：</span><input type="text" name="username"/>
	<span>密码：</span><input  type="password" name="password"/>
	 <input  type="hidden" name="gotoUrl" value="${gotoUrl}"/>
	<input type="submit"/>
	
</form>
</center>

</body>
</html>