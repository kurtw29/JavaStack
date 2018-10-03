<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEMO JSP</title>
</head>
<body>
	<h1>Hello World</h1>
	<%!
	public int add(int a, int b){
		return a + b;
	}
	%>
	
	<%
	int i = 2;
	int j = 4;
	%>
	<p>The time is: <%= new Date() %></p>
	<h3><%= add(i,j) %></h3>
	
	<%for(int indx = 0; indx < 5; indx++){ %>
		<h1><%= indx %></h1>
	<% } %>
	
	
</body>
</html>