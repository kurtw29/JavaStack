<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make a pet!</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style><%@include file="/WEB-INF/css/form.css"%></style>

</head>
<body>
<div class='wrapper'>
	<h1>Make a pet!</h1>
	<form action="Cats" method="post" class='catForm col-4'>
		<h2 class="formTitle">Make a Cat!</h2>
		<div class='form-group row'>
			<label for="catName" class="col-sm-2 col-form-label">Name</label>
    		<div class="col-sm-10">
      			<input type="text" class="form-control" name="name" id="catName">
    		</div>
		</div>
		<div class='form-group row'>
			<label for="catBreed" class="col-sm-2 col-form-label">Breed</label>
    		<div class="col-sm-10">
      			<input type="text" class="form-control" name="breed" id="catBreed">
    		</div>
		</div>
		<div class='form-group row'>
			<label for="catWeight" class="col-sm-2 col-form-label">Weight</label>
    		<div class="col-sm-10">
      			<input type="number" class="form-control" name="weight" id="catWeight">
    		</div>
		</div>
		<button type="submit" class="btn btn-success">Submit</button>
	</form>
	
	<form action="Dogs" method="post" class='dogForm col-4'>
		<h2 class="formTitle">Make a Dog!</h2>
		<div class='form-group row'>
			<label for="dogName" class="col-sm-2 col-form-label">Name</label>
    		<div class="col-sm-10">
      			<input type="text" class="form-control" name="name" id="dogName">
    		</div>
		</div>
		<div class='form-group row'>
			<label for="dogBreed" class="col-sm-2 col-form-label">Breed</label>
    		<div class="col-sm-10">
      			<input type="text" class="form-control" name="breed" id="dogBreed">
    		</div>
		</div>
		<div class='form-group row'>
			<label for="dogWeight" class="col-sm-2 col-form-label">Weight</label>
    		<div class="col-sm-10">
      			<input type="number" class="form-control" name="weight" id="dogWeight">
    		</div>
		</div>
		<button type="submit" class="btn btn-success">Submit</button>
	</form>
</div>
</body>
</html>