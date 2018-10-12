<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${language.getName() }</title> <!-- LANAGUAGE NAME HERE -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class='row'>
		<form action="/languages/${language.getId() }" method="post" > <!-- ${languages.id} -->
		    <input type="hidden" name="_method" value="delete">
		    <input class='link' type="submit" value="Delete">
		</form>
		<a href="/languages">Dashboard</a>
	</div>
	<form:form action="/languages/${language.getId()}" method="post" modelAttribute="language">
   		<input type="hidden" name="_method" value="put">
		<table class='table'>
			<thead></thead>
			<tbody>
				<tr>
					<td>
						<form:label path="name">Name</form:label>
				        <form:input path="name"/>
				        <form:errors path="name"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="creator">Creator</form:label>
				        <form:input path="creator"/>
				        <form:errors path="creator"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="version">Version</form:label>
				        <form:input path="version"/>
				        <form:errors path="version"/>
					</td>
				</tr>
			</tbody>
		</table>
		<input type='submit' value='Submit'/>
	</form:form>
</body>
</html>