<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String message=(String)request.getAttribute("message");
	if(message!=null){
		%>
		<jsp:include page="error.jsp"></jsp:include>
		<p style="color:red"><%= message %></p>
	<%} %>

		<form action="student">
		Roll : <input type="number" name="roll"><br>
		Name : <input type="text" name="name"><br>
		Email : <input type="email" name="email"><br>
		Phone : <input type="tel" name="phone"><br>
		Address :<textarea rows="5" cols="15" name="address"></textarea> <br>
		Age : <input type="number" name="age"><br>
		Password : <input type="text" name="password"><br>
		<input type="submit" value="Add Student">
	</form>
</body>
</html>