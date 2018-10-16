<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>${category.getName()} <a href="/">Back to index page</a></h1>
	<div class="col-md-6">
		<h3>Products</h3>
		<ul>
			<c:forEach items="${products }" var="product" >
			<li>${product.getName()}</li>
			</c:forEach>
		</ul>
	</div>
	<div class="col-md-6">
		<form action="/category/${category.getId() }/addProduct" method="POST"> <!-- include {category.id} in URL & modelAttribute -->
		  <div class="form-row align-items-center">
		    <div class="col-auto">
		      <label class="sr-only" for="product">Add Product</label>
		      <select class="form-control mb-2" name="productId">
		      	<c:forEach items="${productsExcluded }" var="productExcl">
		      		<option value="${productExcl.getId()}">${productExcl.getName()}</option>
		      	</c:forEach>
		      </select>
		    </div>
		  </div>
		  <input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>