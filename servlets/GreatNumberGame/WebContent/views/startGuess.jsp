<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Great Number Game</title>
</head>
<body>
	<h1>Welcome to the Great Number Game!</h1>
	<h3>I am thinking of a number between 1 to 100</h3>
	<h3>Take a guess! <c:out value="${number }"/></h3>
	<!-- if guessed correct -->
	<c:if  test = "${status.equals('correct')}">
		<div class='result'>
			<p> <c:out value="${number}"/> was the number!</p>
			<a href='home' class='btn'>Play Again</a>
		</div>
	</c:if>
	<!-- if guessed too high -->
	<c:if  test = "${status.equals('high')}">
		<div class='result'>
			<p> <c:out value="${guessNumber}"/> too high!</p>
			<p>Keep guessing!</p>
		</div>
	</c:if>
	<!-- if guessed too low -->
	<c:if  test = "${status.equals('low')}">
		<div class='result'>
			<p> <c:out value="${guessNumber}"/> too low!</p>
			<p>Keep guessing!</p>
		</div>
	</c:if>
	<form class='guess' action='home' method='post'>
		<input type='number' name='guessNumber' />
		<button type='submit'>Submit</button>
	</form>
</body>
</html>