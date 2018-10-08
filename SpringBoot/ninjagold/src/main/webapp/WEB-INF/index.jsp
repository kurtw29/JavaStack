<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
</head>
<body>
	<h1>Your Gold: <span class="gold">${gold }</span></h1>
	<div class="forms">
		<!-- FARM form -->
		<form action="procGold" method="post">
			<h1>Farm</h1>
			<h3>(earns 10-20 gold)</h3>
			<input type="hidden" name="name" value="farm" />
			<button type="submit">Find Gold!</button>
		</form>
		<!-- CAVE form -->
		<form action="procGold"  method="post">
			<h1>Cave</h1>
			<h3>(earns 5-10 gold)</h3>
			<input type="hidden" name="name" value="cave" />
			<button type="submit">Find Gold!</button>
		</form>
		<!-- HOUSE form -->
		<form action="procGold" method="post">
			<h1>House</h1>
			<h3>(earns 2-5 gold)</h3>
			<input type="hidden" name="name" value="house" />
			<button type="submit">Find Gold!</button>
		</form>
		<!-- CASINO form -->
		<form action="procGold" method="post">
			<h1>Casino</h1>
			<h3>(earns/takes 0-50 gold)</h3>
			<input type="hidden" name="name" value="casino" />
			<button type="submit">Find Gold!</button>
		</form>
		
		<!-- Display record of activities -->
		<h1 class='activities'>Activities:</h1>
		<ul>
			<c:forEach var="log" items="${list}">
			<li>${log}</li>
			</c:forEach>			
		</ul>
		
	</div>
</body>
</html>