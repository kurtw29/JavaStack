<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	<div class='navbar'>
		Songs by artist: ${searchedWord }
		<form action="/search/" method="GET">
			<input type='text' name="artist" value="${searchedWord }"/>
			<input type="submit" value="New Search" />
		</form>
		<a href="/dashboard">Dashboard</a>
	</div>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs }" var="song">
			<tr>
				<td><a href="/songs/${song.id }">${song.title }</a></td>
				<td>${song.rating }</td>
				<td>
					<form action="/song/${song.id }" method="post"> <!-- song.id -->
						<input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>