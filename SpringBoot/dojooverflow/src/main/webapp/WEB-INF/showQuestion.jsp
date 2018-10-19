<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question profile</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>${question.question}?</h1>
	
	<p>Tags: 
	<c:forEach items="${question.tags }" var="tag">
		<span class="btn btn-outline-primary">${tag.subject} </span>
	</c:forEach>
	</p>
	<div class="row">
	<div class="col-md-4">
		<table class="table table-striped">
			<thead><tr><th>Answers</th></tr></thead>
			<tbody>
				<c:forEach items="${question.answers }" var="answer">
				<tr><td>${answer.answer}</td></tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-md-4">
		<h3>Add your answer: </h3>
		<form:form action="/answers/create/${question.id }" method="post" modelAttribute="answerForm">
			<form:label path="answer">Answer:</form:label>
			<form:input path="answer" type="text"/>
			<p><form:errors path="answer" /></p>
			<input type='submit' value="Answer it!"/>
		</form:form>
	</div>
	</div>
	<a href="/questions">Back to Dashboard</a>
	</div>
</body>
</html>