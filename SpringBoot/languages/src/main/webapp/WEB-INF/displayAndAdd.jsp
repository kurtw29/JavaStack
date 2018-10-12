<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">Version</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="language" items="${languages}">
    <tr>
      <th scope="row"><a href="/languages/${language.id}">${language.name }</a></th>
      <td>${language.creator }</td>
      <td>1.8</td>
      <td>
      	<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
	</form>
      	<a href="/languages/${language.id}/edit">edit</a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<!-- Create Language Form -->
<form:form action="/languages" method="post" modelAttribute="lang">
    <p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:textarea path="creator"/>
        <span style='color:red;'><form:errors path="creator"/></span>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:input type="text" path="version"/>
        <form:errors path="version"/>     
    </p>    
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>