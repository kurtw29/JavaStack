<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New contact</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<form action="/contact/create" method="get" class="container mt-5">
		<h1>Contact Info</h1>
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td><label for="studentId">Student:</label></td>
					<td>
					<select name="student">
						<c:forEach items="${students }" var="s">
						<option value="${s.id }">${s.firstName} ${s.lastName }</option>	
						</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td><label for="address">Address:</label></td>
					<td><input name="address" type="text" /></td>
				</tr>
				<tr>
					<td><label for="city">City:</label></td>
					<td><input name="city" type="text" /></td>
				</tr>
				<tr>
					<td><label for="state">State:</label></td>
					<td><input name="state" type="text" /></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Create"/>
	</form>
</body>
</html>