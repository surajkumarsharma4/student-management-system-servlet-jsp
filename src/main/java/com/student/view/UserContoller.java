package com.student.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.student.dao.DaoImplementation;
import com.student.dao.StudentDao;
import com.student.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/student")
public class UserContoller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int roll=Integer.parseInt(req.getParameter("roll")) ;
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		Long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		int age=Integer.parseInt(req.getParameter("age"));
		String password=req.getParameter("password");

		Student student=new Student();
		student.setRoll(roll);
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		student.setAddress(address);
		student.setAge(age);
		String message=null;
		boolean saveStudent=false;
		StudentDao dao=new DaoImplementation();
		try {
			dao.saveStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
			e.printStackTrace();
		}
		if(saveStudent) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("message", message);
			req.getRequestDispatcher("form.jsp").forward(req, resp);
		}
		
	}
}
