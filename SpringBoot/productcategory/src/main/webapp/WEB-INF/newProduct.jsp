<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>New Product <a href="/">Back to index page</a></h1>
	<form:form action="/product/create" method="POST" modelAttribute="product">
	  <div class="form-group">
	    <form:label path="name">Name:</form:label>
	    <form:input class="form-control" path="name" />
	    <form:errors path="name" />
	  </div>
	  <div class="form-group">
	    <form:label path="description">Description:</form:label>
	    <form:input class="form-control" path="description" />
	    <form:errors path="description" />
	  </div>
	  <div class="form-group">
	    <form:label path="price">Price:</form:label>
	    <form:input class="form-control" path="price" />
	    <form:errors path="price" />
	  </div>
	  <button type="submit" class="btn btn-primary">Create</button>
	</form:form>
</body>
</html>