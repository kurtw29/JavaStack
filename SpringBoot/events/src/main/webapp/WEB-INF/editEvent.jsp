<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Events</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<style>
		.errors{
			color:red;
		}
	</style>
</head>
<body>
	<h1>${event.name}</h1>
		<h3>Edit Event</h3>
		<div class="col-md-4">
	<form:form action="/events/${eventId }/update" method="POST" modelAttribute="event">
		<input type="hidden" name="_method" value="PUT"/>
		<div class="form-group row">
			<form:label path="name" class="col-sm-2 col-form-label">Name:</form:label>
			<div class="col-sm-10">
			  <form:input path="name" type="text" class="form-control" />
			  <form:errors path="name" class="errors"/>
			</div>
		</div>
		<div class="form-group row">
		    <form:label path="date" class="col-sm-2 col-form-label">Date:</form:label>
		    <div class="col-sm-10">
		      <form:input path="date" type="date" class="form-control" />
		      <form:errors path="date" class="errors" />
	    	</div>
		</div>
		<div class="form-group row">
		  	<form:label path="location" class="col-sm-2 col-form-label">Location:</form:label>
		  	<div class="col-sm-8">
		  		<form:input path="location" type="text" class="form-control" />
		  		<form:errors path="location" />
		  	</div>
		  	<div class="col-sm-2">
		  		<form:select path="state" class="form-control">
		  			<form:option value="CA">CA</form:option>
		  			<form:option value="WA">WA</form:option>
		  			<form:option value="TX">TX</form:option>
		  			<form:option value="MI">MI</form:option>
		  			<form:option value="NY">NY</form:option>
		  		</form:select>
		  		<form:errors path="state" />
		  	</div>
		  </div>
		<div class="form-group text-right">
	  		<input type="submit" value="Edit" class="btn btn-primary">
	  	</div>
	</form:form>
	</div>
	
	</div>
	
	<div class="my-2 my-sm-0">
	<a class="btn btn-success" href="/events">Back to Dashboard</a>
	<a class="btn btn-primary" href="/logout">Logout</a>
</body>
</html>