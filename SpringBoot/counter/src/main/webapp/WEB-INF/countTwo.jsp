<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter Increment by 2</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>You have visited <a href="/">http://localhost:8080</a> <c:out value = "${countTwo}" /> times.</h1>
	<h2><a href="/">Test another visit?</a></h2>
	<h2><a href="/resetCounterTwo">Reset</a></h2>
</body>
</html>