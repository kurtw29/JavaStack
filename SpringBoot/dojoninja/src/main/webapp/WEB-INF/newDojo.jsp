<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h1>New Dojo</h1>
		<form:form action="/dojos/create" method='POST' modelAttribute="dojo" class="form-inline">
			<form:label path="location" class="my-1 mr-2">Name: </form:label>
			<form:input path="location" type='text'/>
			<form:errors path="location" />
			<input type="submit" value="Create" class="btn btn-success"/>
		</form:form>
	</div>
</body>
</html>