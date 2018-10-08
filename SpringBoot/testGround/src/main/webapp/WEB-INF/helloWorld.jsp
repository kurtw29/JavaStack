<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
<link rel="stylesheet" href="css/style.css">
<script type='text/javascript' src="js/app.js"></script>
</head>
<body>
	<h1>Hello World</h1>
	<h2><c:out value="${sign}"/></h2>
</body>
</html>