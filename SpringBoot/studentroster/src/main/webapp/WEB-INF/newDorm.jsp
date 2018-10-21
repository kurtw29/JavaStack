<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NewDormitories</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<form action="/dorms/create" method="get" class="container mt-5">
		<h1>Dormitories</h1>
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td><label for="name">Name:</label></td>
					<td><input name="name" type="text" /></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Create"/>
	</form>
</body>
</html>