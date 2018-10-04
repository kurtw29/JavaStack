<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clicker</title>
<style><%@include file="/css/style.css"%></style>
</head>
<body>
	<div class='container'>
		<a href='Counter' class='btn'>Click Me!</a>
		<h2>You have clicked this button <c:out value="${count}"/> times</h2>
		<h2>You have clicked <%= session.getAttribute("count") %> session.getAttribute()</h2>
	</div>
</body>
</html>