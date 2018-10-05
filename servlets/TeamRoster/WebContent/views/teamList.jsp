<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team Roster</title>
</head>
<body>
	<h2>Prototype Roster</h2><a href='teams'>New Team</a>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Team</th>
	      <th scope="col">Players</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">Ninja</th>
	      <td>2</td>
	      <td><a href='team/id'>Detail</a><a href='delete/id'>Delete</a></td>
	    </tr>
	    <tr>
	      <th scope="row">Samurai</th>
	      <td>5</td>
	      <td><a href='team/id'>Detail</a><a href='delete/id'>Delete</a></td>
	    </tr>
	   </tbody>
	</table>
</body>
</html>