<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

	<style>
		.errors{
			color:red;
		}
	</style>

</head>
<body>
	<h1 class="text-center">Welcome</h1>
	<div class="row justify-content-around">
	<!-- registration section -->
	<div class="col-md-4">
		<h2>Registration</h2>
		<form:form action="/reg" method="POST" modelAttribute="user">
		  <div class="form-group row">
		    <form:label path="firstName" class="col-sm-2 col-form-label">First Name</form:label>
		    <div class="col-sm-10">
		      <form:input path="firstName" type="text" class="form-control"/>
		      <form:errors path="firstName" class="errors"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <form:label path="lastName" class="col-sm-2 col-form-label">Last Name</form:label>
		    <div class="col-sm-10">
		      <form:input path="lastName" type="text" class="form-control"/>
		      <form:errors path="lastName" class="errors"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <form:label path="email" class="col-sm-2 col-form-label">Email:</form:label>
		    <div class="col-sm-10">
		      <form:input path="email" type="text" class="form-control"/>
		      <form:errors path="email" class="errors"/>
		    </div>
		  </div>
		  <div class="form-group row">
		  	<form:label path="location" class="col-sm-2 col-form-label">Location:</form:label>
		  	<div class="col-sm-8">
		  		<form:input path="location" type="text" class="form-control"/>
		  		<form:errors path="location" class="errors" />
		  	</div>
		  	<div class="col-sm-2">
		  		<form:select path="state" class="form-control">
		  			<form:option value="CA">CA</form:option>
		  			<form:option value="WA">WA</form:option>
		  			<form:option value="TX">TX</form:option>
		  			<form:option value="MI">MI</form:option>
		  			<form:option value="NY">NY</form:option>
		  		</form:select>
		  		<form:errors path="state" class="errors" />
		  	</div>
		  </div>
		  <div class="form-group row">
		    <form:label path="password" class="col-sm-2 col-form-label">Password:</form:label>
		    <div class="col-sm-10">
		      <form:input path="password" type="password" class="form-control" />
		      <form:errors path="password"  class="errors" />
		    </div>
		  </div>
		  <div class="form-group row">
		    <form:label path="passwordConfirmation" class="col-sm-2 col-form-label">PW Confirm:</form:label>
		    <div class="col-sm-10">
		      <form:input path="passwordConfirmation" type="password" class="form-control" />
		      <form:errors path="passwordConfirmation" class="errors" />
		    </div>
		  </div>
		  <div class="form-group text-right">
		  	<input type="submit" value="Register" class="btn btn-primary">
		  </div>
		</form:form>
	</div><!-- end of registration section -->
	
	<!-- login section -->
	<div class="col-md-4">
	<form action="/login" method="POST">
		<h2>Login</h2>
	  	<p class="errors"><c:out value="${loginError}"/></p>
		<div class="form-group row">
			<label for="emailLog" class="col-sm-2 col-form-label">Email:</label>
			<div class="col-sm-10">
			  <input name="emailLog" type="text" class="form-control">
			</div>
		</div>
		<div class="form-group row">
		    <label for="passwordLog" class="col-sm-2 col-form-label">Password:</label>
		    <div class="col-sm-10">
		      <input name="passwordLog" type="password" class="form-control" />
	    	</div>
		</div>
		<div class="form-group text-right">
	  		<input type="submit" value="Login" class="btn btn-primary">
	  	</div>
	</form>
	</div><!-- end of login section -->
	</div>
</body>
</html>