<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎访问demo2</title>
</head>
<body>
欢迎访问demo2，这是demo2的主页！
<c:forEach var="url" items="${hiddenUrl}">
	<iframe src="${url}" width="0px" height="0px" style="display: none"></iframe>

</c:forEach>
</body>
</html>