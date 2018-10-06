<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${selectedTeam.getName()}"/>: New Player</title>
</head>
<body>
	<h1>Add a player to team <c:out value="${selectedTeam.getName()}"/></h1>
	<form method="post" action="player">
	  <div class="form-group">
	    <label for="addFirstName">First Name:</label>
	    <input type="text" class="form-control" id="addFirstName" name="firstName">
	  </div>
	  <div class="form-group">
	    <label for="addLastName">Last Name:</label>
	    <input type="text" class="form-control" id="addLastName" name="LastName">
	  </div>
	  <div class='form-group'>
	  	<label for="age">Age</label>
	  	<input type="number" class="form-control" min="18" max="65" id="age" name="age">
	  	<input type="hidden" name="team" value="<c:out value="${selectedTeam.getId()}"/>">
	  </div>
	  <button type="submit" class="btn btn-primary">Add</button>
	</form>
</body>
</html>