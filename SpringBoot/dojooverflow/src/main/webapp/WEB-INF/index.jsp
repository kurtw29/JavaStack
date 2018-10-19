<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions Assignment</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questions }" var="question">
			<tr>
				<td><a href="/questions/${question.id}">${question.question}</a></td>
				<td>
				<c:forEach items="${question.tags }" var="tag">
					<span>${tag.subject}</span>
				</c:forEach>
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td>All the tags</td>
				<td>
					<c:forEach items="${tags }" var="tag">
						<span>${tag.subject}</span>
					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
	<a href="/questions/new">New Question</a>
</body>
</html>