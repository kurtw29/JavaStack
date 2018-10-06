<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team <c:out value="${selectedTeam.getName()}"/></title>
</head>
<body>
	<!-- Adding new player base on teamID -->
	<c:url value="/player" var="playerUrl">
		<c:param name="teamId" value="${selectedTeam.getId()}" />
	</c:url>
	<h1>Team: <c:out value="${selectedTeam.getName()}"/></h1> <a href="<c:out value="${playerUrl}"/>">New player</a>
	
	<!-- Display table of players -->
	<table class="table">
	  <thead>
	    <tr>
			<th scope="col">Id</th>
	      	<th scope="col">First Name</th>
	      	<th scope="col">Last Name</th>
	      	<th scope="col">Age</th>
	      	<th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="player" items="${ selectedTeam.getPlayers() }">
	    <tr>
	    	<!-- show player id -->
	      <th scope="row"><c:out value="${player.getId()}"/></th>
	      
	    	<!-- show player first name -->
	      <td><c:out value="${player.getFirstName()}"/></td>
	      
	      <!-- show player last name -->
	      <td><c:out value="${player.getLastName()}"/></td>
	      
	      <!-- show player age-->
	      <td><c:out value="${player.getAge()}"/></td>
	      
	      <!-- DEtail and delete link buttons -->
	      <c:url value="/DeletePlayer" var="url_deleteplayer">
	      	<c:param name="deletePlayerId" value="${ player.getId() }"/>
	      	<c:param name="teamId" value="${selectedTeam.getId() }"/>
	      </c:url>
	      <td style='text-align:center;'>
		      <a href='<c:out value="${url_deleteplayer}" />'>Delete</a>
		  </td>
	    </tr>
	    </c:forEach>
	   </tbody>
	</table>
	
</body>
</html>