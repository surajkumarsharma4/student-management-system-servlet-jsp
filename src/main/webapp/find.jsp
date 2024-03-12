<%@page import="com.student.exception.StudentNotFoundException"%>
<%@page import="java.rmi.StubNotFoundException"%>
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
	<h2>Find Student By Roll Number</h2>
	<form action="">
		<label for="roll">Enter Roll Number : </label>
		<input type="number" name="roll" id="roll" required><br>
		<input type="submit" value="Search Student">
	</form>
	<%-- display student if found --%>
<%
try{
	String rollParam=request.getParameter("roll");
	if(rollParam!=null && !rollParam.isEmpty()){
		int rollno=Integer.parseInt(rollParam);
		StudentDao dao=new DaoImplementation();
		Student student=dao.findStudentById(rollno);
		if(student!=null){
		%>
		<h3>Student Details</h3>
		<p>Roll Number : <%=student.getRoll() %></p>
		<p>Name : <%=student.getName() %></p>
		<p>Email : <%=student.getEmail() %></p>
		<p>Address : <%=student.getAddress()%></p>
		<p>Age : <%=student.getAge() %></p>
		<p>Password : <%=student.getPassword() %></p>
		<p>Phone : <%=student.getPhone() %></p>
		
		<a href="update.jsp?id=<%=student.getRoll()%>">Update</a>
		<a href="delete.jsp?id=<%=student.getRoll()%>">Delete</a>
		<%
		}
		else{
			throw new StudentNotFoundException("Student with ID "+rollno+" not found");
		}		
	}
	else{
		//handle case where roll number parameter is not provided
		//throw new IllegalArgumentException("Roll number parameter")
		
	}
}
catch(NumberFormatException e){
	//handle case where provided roll number is a not valid number
	System.out.println(" roll number paramer is missing");
}catch(StudentNotFoundException e){
	//handle case where student is not find
	%>
	<h1 style=""color:red;"><%=e.getMessage() %></h1>
	<%	
	}catch(IllegalArgumentException e){
		//hndle case where roll number parameter is missing
	%>
	
	<h1 style=""color:red;"><%=e.getMessage() %></h1>
	<%
	}
	%>
	
</body>
</html>