<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Cat</title>
</head>
<body>
	<h1>You created a <c:out value="${cat.breed }"/></h1>
	<h1>
		<c:out value="${cat.showAffection()}"/>
	</h1>
</body>
</html>