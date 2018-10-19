<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>What is your question?</h1>
	<form action="/questions/create" method="post">
	<table>
		<thead></thead>
		<tbody>
			<tr>
				<td><label for="question">Questions:</label></td>
				<td><input name="question" type="text"/></td>
			</tr>
			<tr>
				<td><label for="tags">Tags:</label></td>
				<td><input name="tags" type="text" /></td>
				<td><span>eg) tag1, tag2, tag3</span></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" value="Submit" />
	<p style="color:red;"><c:out value="${tagError}"/></p>
	<p style="color:red;"><c:out value="${questionError}"/></p>
	</form>
</body>
</html>