<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	<h3>Top Ten Songs: <span><a href="/dashboard">Dashboard</a></span></h3>
	<c:forEach items="${songs }" var="song">
	<p>${song.rating } - <a href="/songs/${song.id }">${song.title}</a> - ${song.artist }</p>
	</c:forEach>
</body>
</html>