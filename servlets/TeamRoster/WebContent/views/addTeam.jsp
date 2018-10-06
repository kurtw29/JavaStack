<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Team</title>
</head>
<body>
	<h1>Create a new Team</h1>
	<form method="post" action="teams">
	  <div class="form-group">
	    <label for="addTeam">Team Name:</label>
	    <input type="text" class="form-control" id="addTeam" name="teamName">
	  </div>
	  <button type="submit" class="btn btn-primary">Create</button>
	</form>
</body>
</html>