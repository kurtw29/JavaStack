<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>${product.getName()} <a href="/">Back to index page</a></h1>
	<div class="col-md-5">
		<h3>Categories</h3>
		<ul>
			<c:forEach items="${categories }" var="category">
			<li>${category.getName()}</li>
			</c:forEach >
		</ul>
	</div>
	<div class="col-md-5">
		<form action="/product/${product.getId() }/addCategory" method="POST"> <!-- include {product.id} in URL & modelAttribute -->
		  <div class="form-row align-items-center">
		    <div class="col-auto">
		      <label class="sr-only" for="category">Add Category</label>
		      <select class="form-control mb-2" name="categoryId">
		      	<c:forEach items="${categoriesExcluded }" var="categoryExclude">
		      		<option value="${categoryExclude.getId()}">${categoryExclude.getName()}</option>
		      	</c:forEach>
		      </select>
		    </div>
		  </div>
		  <input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>