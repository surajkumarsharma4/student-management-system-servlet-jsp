package com.student.view;

import java.io.IOException;
import java.sql.SQLException;

import com.student.dao.DaoImplementation;
import com.student.dao.StudentDao;
import com.student.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/studentupdate")
public class UserUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDao dao=new DaoImplementation();
		
		Student student=new Student();
		student.setRoll(Integer.parseInt(req.getParameter("roll")));
		student.setName(req.getParameter("name"));
		student.setEmail(req.getParameter("email"));
		student.setAddress(req.getParameter("address"));
		student.setAge(Integer.parseInt(req.getParameter("age")));
		student.setPassword(req.getParameter("password"));
		student.setPhone(Long.parseLong(req.getParameter("phone")));
		
		String mesage=null;
		boolean saveStudent=false;
		
		try {
			saveStudent =dao.updateStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(saveStudent) {
			req.getRequestDispatcher("find.jsp").forward(req, resp);;
		}
		else {
			req.setAttribute("message", mesage);
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
		
	}
}
