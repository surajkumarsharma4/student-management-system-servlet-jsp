<%@page import="com.student.entity.Student"%>
<%@page import="com.student.dao.DaoImplementation"%>
<%@page import="com.student.dao.StudentDao"%>
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
	int id=Integer.parseInt(request.getParameter("id")) ;
	StudentDao dao=new DaoImplementation();
	Student student=dao.findStudentById(id);
%>
<form action="studentupdate">
	roll No:<input type="number" name="roll" value="<%=student.getRoll() %>"><br>
	Name:<input type="text" name="name" value="<%=student.getName() %>"><br>
	Email:<input type="email" name="email" value="<%=student.getEmail() %>"><br>
	Address :<textarea rows="5" cols="15" name="address" ><%=student.getAddress() %></textarea><br>
	Age:<input type="number" name="age" value="<%=student.getAge() %>"><br>
	Password:<input type="password" name="password" value="<%=student.getPassword() %>"><br>
	Phone:<input type="tel" name="phone" value="<%=student.getPhone() %>"><br>
	<input type="submit" value="Update Student">
	
	
</form>
</body>
</html>