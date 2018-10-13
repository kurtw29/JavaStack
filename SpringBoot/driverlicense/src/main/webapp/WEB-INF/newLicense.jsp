<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1>New License</h1>
		<form:form action="/addNewLicense" method="post" modelAttribute="license"> <!-- form for create new license -->
		<table class='table'>
			<thead></thead>
			<tbody>
				<tr class='row'>
					<td><form:label path="person">Person:</form:label></td>
					<td><form:select path="person">
							<c:forEach items="${persons }" var="person">
							<form:option value="${person }" label="${person.getFirstName()} ${person.getLastName()}"/>
							</c:forEach>
					</form:select>
					<form:errors path="person"/>
					</td>
				</tr>
				<tr class='row'>
					<td><form:label path="state">State:</form:label></td>
					<td><form:input path="state" type='text'/>
					<form:errors path="state" />
					</td>
				</tr>
				<tr class='row'>
					<td><form:label path="expiration_date">Expiration Date:</form:label></td>
					<td><form:input path="expiration_date" type='date'/>
					<form:errors path="expiration_date" />
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