<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team Roster</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h2 style='text-align:center;'>Prototype Roster</h2><a style='text-align:center; display:block; text-align:center;' href='teams'>New Team</a>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Team</th>
	      <th scope="col">Players</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="team" items="${ teamList }">
	    <tr>
	    	<!-- show team name -->
	      <th scope="row"><c:out value="${team.getName()}"/></th>
	      
	      <!-- show number of players on the team-->
	      <td><c:out value="${team.getPlayers().size()}"/></td>
	      
	      <!-- DEtail and delete link buttons -->
	      <c:url value="/DeleteTeam" var="url_deleteTeam">
	      	<c:param name="deleteTeamId" value="${ team.getId() }"/>
	      </c:url>
	      <c:url value="/teams" var="url_detailTeam">
	      	<c:param name="detailTeamId" value="${team.getId() }"/>
	      </c:url>
	      <td style='text-align:center;'>
		      <a style="margin-right:30px;" href='<c:out value="${url_detailTeam}" />'>Detail</a>
		      <a href='<c:out value="${url_deleteTeam}" />'>Delete</a>
		  </td>
	    </tr>
	    </c:forEach>
	   </tbody>
	</table>
</body>
</html>