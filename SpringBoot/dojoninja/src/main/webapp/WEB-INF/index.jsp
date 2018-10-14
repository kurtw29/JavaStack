<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body> 
	<div class="container d-flex justify-content-around mt-5">
		<a href="/dojos/new">Create a Dojo</a>
		<a href="/ninjas/new">Create a Ninja</a>
		<form action="/findDojo" method="POST">
			<div class="input-group">
				<select name='locationId' class="custom-select">
					<c:forEach items="${dojos }" var="dojo">
					<option value="${dojo.getId()}">${dojo.getLocation() }</option>
					</c:forEach>
				</select>
				<input class="input-group-append"type="submit" value="Show Ninjas"/>
			</div>
		</form>
	</div>
</body>
</html>