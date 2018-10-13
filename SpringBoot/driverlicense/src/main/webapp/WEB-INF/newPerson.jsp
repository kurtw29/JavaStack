<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>New Person</h1>
		<form:form action="/persons/new" method="post" modelAttribute="person">
		<table class='table'>
			<thead></thead>
			<tbody>
				<tr class='row'>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" />
						<form:errors path="firstName" />
					</td>
				</tr>
				<tr class='row'>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName"/>
						<form:errors path="lastName"/>
					</td>
				</tr>
				<tr class='row'>
					<td></td>
					<td><input type="submit" value='Create'/></td>
				</tr>
			</tbody>
		</table>
		</form:form>
	</div>
</body>
</html>