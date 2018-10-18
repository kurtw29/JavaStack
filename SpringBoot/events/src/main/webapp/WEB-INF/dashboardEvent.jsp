<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="navbar">
		<h1 class='navbar-brand'>Welcome, <c:out value="${logUser.getFirstName()}"/></h1>
		<a class='my-2 my-sm-0 btn btn-primary' href="/logout">Logout</a>
	</div>
	<!-- events in user's state -->
	<p>Here are some of the events in your state (<c:out value="${logUser.getState()}"/>):</p>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Date</th>
	      <th scope="col">Location</th>
	      <th scope="col">Host</th>
	      <th scope="col">Action/Status</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${sameStateEvents }" var="stateEvent">
	    <tr>
	      <td><a href="/events/${stateEvent.getId()}">${stateEvent.getName()}</a></td> <!-- {event.id -->
	      <td><fmt:formatDate type="date" value="${stateEvent.getDate()}" /></td>
	      <td>${stateEvent.getLocation()}</td>
	      <td>${stateEvent.host.firstName}</td>
	      <td>
		      <c:set var="logU" value="${logUser}" />
		      <c:set var="attending" value="${stateEvent.getAttendees() }"/>
		      <c:set var="hostId" value="${stateEvent.host.id }"/>
	      <c:choose>
		      <c:when test="${hostId == logUser.id}">
		      	<!-- show "edit" and "delete" if user is the owner of event -->
		      	<a href="/events/${stateEvent.getId()}/edit">Edit</a>
		      	<a href="/events/${stateEvent.getId()}/delete">Delete</a>
		      </c:when>
		      <c:when test="${!attending.contains(logUser)}">
		      	<a href="/events/${stateEvent.getId()}/join">Join</a>
		      </c:when>
	 	      <c:otherwise>
		      	<!-- if joined show text "Joining" and show another form "Cancel" -->
		      	<span>Joining</span>
		      	<a href="/events/${stateEvent.getId()}/cancel">Cancel</a>
		      </c:otherwise>
	      </c:choose>
	      </td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	
	<!-- events in other states -->
	<p>Here are some of the events in other states</p>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Date</th>
	      <th scope="col">Location</th>
	      <th scope="col">State</th>
	      <th scope="col">Host</th>
	      <th scope="col">Action/Status</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${otherStateEvents}" var="event">
	    <tr>
	      <td><a href="/events/${event.id}">${event.name}</a></td>
	      <td><fmt:formatDate type="date" value="${event.date}" /></td>
	      <td>${event.location}</td>
	      <td>${event.state}</td>
	      <td>${event.host.firstName} ${event.host.lastName }</td>
	      <td>
	      <c:set var="logU" value="${logUser}" />
	      <c:set var="attending" value="${event.getAttendees() }"/>
	      <c:set var="hostId" value="${event.host.id }"/>
	      <c:choose>
		      <c:when test="${hostId == logUser.id}">
		      <!-- show "edit" and "delete" if user is the owner of event -->
		      	<a href="/events/${event.id }/edit">Edit</a>
		      	<a href="/events/${event.id}/delete">Delete</a>
			</c:when>
		    <c:when test="${!attending.contains(logUser)}">
		      	<a href="/events/${event.id }/join">Join</a>
      		</c:when>
	 	      <c:otherwise>
		      	<!-- if joined show text "Joining" and show another form "Cancel" -->
	    	  	<span>Joining</span>
		      	<a href="/events/${event.id }/cancel">Cancel</a>
      		</c:otherwise>
	      </c:choose>
	      </td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	
	<!-- form - create an event -->
	<h3>Create an Event</h3>
	<div class="col-md-4">
	<form:form action="/events/create" method="POST" modelAttribute="event">
		<div class="form-group row">
			<form:label path="name" class="col-sm-2 col-form-label">Name:</form:label>
			<div class="col-sm-10">
			  <form:input path="name" type="text" class="form-control"/>
			  <form:errors path="name" class="errors" />
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
		  	<div class="col-sm-7">
		  		<form:input path="location" type="text" class="form-control" />
		  		<form:errors path="location" class="errors" />
		  	</div>
		  	<div class="col-sm-3">
		  		<form:select path="state" class="form-control">
		  			<form:option value="CA">CA</form:option>
		  			<form:option value="WA">WA</form:option>
		  			<form:option value="TX">TX</form:option>
		  			<form:option value="MI">MI</form:option>
		  			<form:option value="NY">NY</form:option>
		  		</form:select>
		  		<form:errors path="state" class="errors" />
		  	</div>
		  </div>
		<div class="form-group text-right">
	  		<input type="submit" value="Create!" class="btn btn-primary">
	  	</div>
	</form:form>
	</div>
</body>
</html>