<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
	<div class='row'>
		<a href="/dashboard">Dashboard</a>
	</div>
	<table>
		<thead></thead>
		<tbody>
			<tr>
				<td>Title</td>
				<td>${song.title }</td>
			</tr>
			<tr>
				<td>Artist</td>
				<td>${song.artist }</td>
			</tr>
			<tr>
				<td>Rating(1-10)</td>
				<td>${song.rating }</td>
			</tr>
			<tr>
				<td>
					<form action="/song/${song.id}" method="post"> <!-- song.id -->
						<input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>