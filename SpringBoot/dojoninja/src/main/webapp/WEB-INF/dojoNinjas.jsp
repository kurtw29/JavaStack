<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>${ dojo.getLocation()} Location Ninjas</h1>
	<table class="table">
		<thead>
			<tr>
				<th>First name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${dojo.getNinjas()}" var="ninja">
			<tr>
				<td>${ninja.firstName }</td>
				<td>${ninja.lastName }</td>
				<td>${ninja.age }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>