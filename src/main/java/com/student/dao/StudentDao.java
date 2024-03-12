package com.student.dao;

import java.sql.SQLException;
import java.util.List;

import com.student.entity.Student;

public interface StudentDao {
		boolean saveStudent(Student student	) throws SQLException;
		boolean updateStudent(Student student) throws SQLException;
		boolean deleteStudent(int roll);
		Student findStudentById(int roll) throws SQLException;
		List<Student> findAllStudent();
		
}
