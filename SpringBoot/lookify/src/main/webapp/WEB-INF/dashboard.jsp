<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify!</title>
</head>
<body>
	<div class='navbar'>
		<a href='/songs/new'>Add New</a>
		<a href="/search/topTen">Top Songs</a>
		<form action="/search/" method="GET"> <!-- song.artist & method=GET -->
			<input type='text' name="artist"/>
			<input type="submit" value="Search Artists" />
		</form>
	</div>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${songs }" var="song">
			<tr>
				<td><a href="songs/${song.id }">${song.title }</a></td> <!-- song.id & song.title -->
				<td>${song.rating }</td> <!-- song.rating -->
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