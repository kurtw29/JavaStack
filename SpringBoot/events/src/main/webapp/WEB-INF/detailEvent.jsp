<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>{Event Name}</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
<style>
	.msg_box{
		height:300px !important; 
		border:1px solid black;
		border-radius:10px;
		overflow:scroll;
		padding:20px;
	}
</style>
</head>
<body>
	<div class="row">
	<!-- Event details -->
	<div class="col-md-4">
		<h1>${event.name}</h1>
		<p>Host: ${event.host}</p>
		<p>Date: <fmt:formatDate type="date" value="${event.date}" /></p>
		<p>Location: ${event.location}, ${event.state}</p>
		<p>People who are attending this event: ${event.attendees.size()}</p>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Location</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${event.attendees }" var="attendee">
				<tr>
					<td>${attendee.firstName} ${attendee.lastName}</td>
					<td>${attendee.location}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- Message Wall -->
	<div class="col-md-4">
		<h1>Message Wall</h1>
		<div class="msg_box">
			<c:forEach items="${messages }" var="msg">
			<p>${msg.user.firstName} says: ${msg.message}</p>
			</c:forEach>
		</div>
		<div class="form-group">
		<form action="/events/${event.id}/message" method="POST">
			<div class="form-group">
				<label for="message">Add Comment</label>
				<textarea name="message" class="form-control"></textarea>
			</div>
			<div class="text-right">
				<input type="submit" value="Submit" class="btn btn-primary"/>
			</div>
		</form>
		</div>
	</div>
	</div>
	
	<div class="my-2 my-sm-0">
		<a class="btn btn-success" href="/events">Back to Dashboard</a>
		<a class="btn btn-primary" href="/logout">Logout</a>
	</div>
</body>
</html>