<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
</head>
<body>
	<h1>Submitted Info</h1>
	<table>
		<thead>
		</thead>
		<tbody>
			<tr>
				<td>Names:</td>
				<td>${name }</td>
			</tr>
			<tr>
				<td>Dojo Location:</td>
				<td>${location }</td>
			</tr>
			<tr>
				<td>Favorite Language:</td>
				<td>${language }!!!! The Best language</td>
			</tr>
				<td>Comment:</td>
				<td>${comment }</td>
			<tr>
		</tbody>
	</table>
	<a href="/">Go Back</a>
</body>
</html>