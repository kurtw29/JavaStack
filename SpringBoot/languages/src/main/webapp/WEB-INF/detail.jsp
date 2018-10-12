<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${language.getName() }</title> <!-- LANAGUAGE NAME HERE -->
</head>
<body>
	<div class='row'>
		<a href="/languages">Dashboard</a>
	</div>
		<h1><c:out value="${language.getName()}"/></h1>
	<p>Creator: <c:out value="${language.getCreator() }"/></p>
	<p>Version: <c:out value="Language Version"/></p>
	<a href="/languages/${language.id}/edit">Edit</a>
	<form action="/languages/${language.getId() }" method="post"> <!-- ${languages.id} -->
	    <input type="hidden" name="_method" value="delete">
	    <input class='link' type="submit" value="Delete">
	</form>
</body>
</html>