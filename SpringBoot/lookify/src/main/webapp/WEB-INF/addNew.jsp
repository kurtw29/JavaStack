<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<form:form action="/song/add" method="post" modelAttribute="song">
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td><form:label path="title">Title</form:label></td>
					<td><form:input path="title"/></td>
					<td><form:errors path="title"/></td>
				</tr>
				<tr>
					<td><form:label path="artist">Artist</form:label></td>
					<td><form:input path="artist"/></td>
					<td><form:errors path="artist"/></td>
				</tr>
				<tr>
					<td>Rating(1-10)</td>
					<td><form:select path="rating">
						<option value="1" label="1"/>
						<option value="2" label="2"/>
						<option value="3" label="3"/>
						<option value="4" label="4"/>
						<option value="5" label="5"/>
						<option value="6" label="6"/>
						<option value="7" label="7"/>
						<option value="8" label="8"/>
						<option value="9" label="9"/>
						<option value="10" selected="selected" label="10"/>
					</form:select></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Add Song"/>
	</form:form>
</body>
</html>