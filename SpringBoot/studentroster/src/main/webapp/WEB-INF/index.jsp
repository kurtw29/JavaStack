<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Roster</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between mb-5">
			<a href="/students/new">Create New Student</a>
			<a href="/contact/new">Create new Contact</a>
			<a href="/students">View all students</a>
		</div>
		<div class="d-flex justify-content-around mt-5">
			<a href="/dorms/new">Create New Dormitory</a>
			<form action="/dorms/show/" method="post">
				<select name="dormId">
					<c:forEach items="${dorms}" var="d">
					<option value="${d.id }">${d.name}</option>
					</c:forEach>
				</select>
				<input type="submit" class="btn-sm btn btn-outline-primary" value="Show Dorm"/>
			</form>
		</div>
	</div>
</body>
</html>