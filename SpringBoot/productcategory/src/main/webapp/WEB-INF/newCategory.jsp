<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>New Category <a href="/">Back to index page</a></h1>
	<form:form action="/category/create" method="POST" modelAttribute="category">
	  <div class="form-group">
	    <form:label path="name">Name:</form:label>
	    <form:input type="text" class="form-control" path="name" />
	    <form:errors path="name"/>
	  </div>
	  <button type="submit" class="btn btn-primary">Create</button>
	</form:form>
</body>
</html>