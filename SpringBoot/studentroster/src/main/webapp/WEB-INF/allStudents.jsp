<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>All Students</h1>
	<a href="/">Back to index</a>
	<table class="table table-striped">
		<thead class='thead-dark'>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts }" var="c">
				<tr>
					<td>${c.student.firstName } ${c.student.lastName }</td>
					<td>${c.student.age }</td>
					<td>${c.address }</td>
					<td>${c.city }</td>
					<td>${state }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>