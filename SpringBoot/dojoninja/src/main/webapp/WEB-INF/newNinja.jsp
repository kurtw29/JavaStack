<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>New Ninja</h1>
	<table>
		<thead></thead>
		<tbody>
		<form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
			<tr>
				<td>Dojo</td>
				<td>
					<form:select path="dojo"> <!-- Display all dojos in options -->
						<c:forEach items="${dojos }" var="dojo">
							<form:option value="${dojo}">${dojo.getLocation()}</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="dojo"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName" type='text' />
				<form:errors path="firstName" />
				</td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:input path="lastName" type='text' />
				<form:errors path="lastName" />
				</td>
			</tr>
			<tr>
				<td><form:label path="age">Age:</form:label></td>
				<td><form:input path="age" type="number" />
				<form:errors path="age" />
				</td>
			</tr>
			<tr>
				<td> </td>
				<td><input type='submit' value="Create" /></td>
			</tr>
		</form:form>
		</tbody>
	</table>
</body>
</html>