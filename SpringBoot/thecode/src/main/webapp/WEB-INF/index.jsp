<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<p class="error">${ error }</p>
		<form action="tryCode" method="post">
			<label class="title">What is the code?</label>
			<input type="text" name="code" />
			<button type="submit">Try Code</button>
		</form>
	</div>
</body>
</html>