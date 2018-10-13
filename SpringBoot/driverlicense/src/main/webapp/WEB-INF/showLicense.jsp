<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
	<div class='container'>
		<h1>${info.getFirstName() } ${info.getLastName() }</h1>
		<table class='table'>
			<thead></thead>
			<tbody>
				<tr>
					<td>License Number</td>
					<td>${info.getLicense().getNumber()}</td>
				</tr>
				<tr>
					<td>State:</td>
					<td>${info.getLicense().getState()}</td>
				</tr>
				<tr>
					<td>Expiration Date:</td>
					<td>${info.getLicense().getExpiration_date() }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class='container'>
		<a href="/persons/new">Back to "New Person"</a>
		<a href="/licenses/new">Back to "New License"</a>
	</div>
</body>
</html>