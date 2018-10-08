<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
</head>
<body>
	<form action="result" method="post">
		<table>
			<thead></thead>
			<tbody>
				<tr>
					<td><label for="name">Your name:</label></td>
					<td><input type="text" name="name" id="name"/></td>
				</tr>
				<tr>
					<td><label for="location">Dojo Location:</label></td>
					<td>
						<select name="location" id="location">
							<option value="San Jose" selected>San Jose</option>
							<option value="Burbank">Burbank</option>
							<option value="Seattle">Seattle</option>
							<option value="Chicago">Chicago</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="language">Favorite Language:</label></td>
					<td>
						<select name="language" id="language">
							<option value="Java" selected>Java</option>
							<option value="Python">Python</option>
							<option value="JavaScript">JavaScript</option>
							<option value="Swift">Swift</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<label for="comment">Comment (optionl)</label>
		<br>
		<textarea name="comment" id="comment" cols="30" rows="4"></textarea>
		<br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>