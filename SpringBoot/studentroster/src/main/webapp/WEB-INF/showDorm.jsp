<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show dormitory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>${dorm.getName()} Dormitory</h1>
	<a href="/">Back to index</a>
	<!-- Student Form -->
	<form class="form" action="/dorm/${dorm.id}/add">
		<div class="form-group">
		<label for="student">Students:</label>
		<select class='select' name="student">
			<c:forEach items="${students }" var="s">
				<option value="${s.id}">${s.firstName } ${s.lastName }</option>
			</c:forEach>
		</select>
		</div>
		<input type="submit" value="Add"/>
	</form>
	
	<!-- Dorm's students table -->
	<table class="table table-striped">
		<thead class='thead-darken'>
			<tr>
				<th>Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>{firstName} {lastName} ${dorm.students.size() }</td>
				<td>
					<a href=#>Remove</a>
				</td>
			</tr>
			<c:forEach items="${dorm.students}" var="s">
			<tr>
				<td>${s.firstName} ${s.lastName}</td>
				<td>
					<form action="/dorm/${dorm.id}/remove" method="get">
					<input type="hidden" name="studentId" value="${s.id }"/>
					<input type="submit" value="Remove"/>
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>