<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkerboard</title>
<link rel='stylesheet' type='text/css' href='./Draw.css'>
</head>
<body>
	<% String width = request.getParameter("width"); %>
	<% String height = request.getParameter("height"); %>
	<h1 class="title">Checkerboard: <%= width %>w x <%= height %>h</h1>
	<table>
		<%for(int indx = 0; indx < Integer.parseInt(height); indx++){ %>
			<tr>
				<%for(int box = 0; box < Integer.parseInt(width); box++){ %>
				
					<%if((box+indx)%2 == 0){ %>
						<td class='purple'></td>
					<% }else{ %>
						<td class='blue'></td>
					<% } %>
				<% } %>
			</tr>
		<% } %>
	</table> <!-- close tag for .container -->
	
</body>
</html>