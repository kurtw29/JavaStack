<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products and Categories</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="center">Product and Categories</h1>
		<div class="container d-flex justify-content-around mt-5">
			<a href="/products/new">Create a new product</a>
			<a href="/categories/new">Create a new category</a>
			
			<form action="/products/show" method="POST"> <!-- route to POST selected product -->
			<div class="input-group">
				<select name='productId' class="custom-select">
					<c:forEach items="${products }" var="product">
					<option value="${product.getId() }">${product.getName()}</option>
					</c:forEach>
				</select>
				<input class="input-group-append"type="submit" value="Show Product"/>
			</div>
			</form>
			<form action="/categories/show" method="POST"> <!-- route to POST selected category -->
			<div class="input-group">
				<select name='categoryId' class="custom-select">
					<c:forEach items="${categories }" var="category">
					<option value="${category.getId()}">${category.getName() }</option>
					</c:forEach>
				</select>
				<input class="input-group-append"type="submit" value="Show Category"/>
			</div>
			</form>
		</div>
	</div>
</body>
</html>