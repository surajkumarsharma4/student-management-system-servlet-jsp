package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.student.entity.Student;
import com.student.model.ConnectDatabase;

public class DaoImplementation implements StudentDao{

	@Override
	public boolean saveStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		
			Connection connection=new ConnectDatabase().getConnection();
			PreparedStatement ps=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());		
			ps.setString(4, student.getAddress());
			ps.setInt(5, student.getAge());
			ps.setString(6, student.getPassword());
			ps.setLong(7, student.getPhone());
			int execute=ps.executeUpdate();
			if(execute>0) {
				return true;
			}
		
		return false;
	}

	@Override
	public boolean updateStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=new ConnectDatabase().getConnection();
		PreparedStatement ps=connection.prepareStatement("update student set roll=?,name=?,email=?,address=?,age=?,password=?,phone=? where roll=?");
		ps.setInt(1, student.getRoll());
		ps.setString(2, student.getName());
		ps.setString(3, student.getEmail());
		ps.setString(4,student.getAddress());
		ps.setInt(5, student.getAge());
		ps.setString(6, student.getPassword());
		ps.setLong(7, student.getPhone());
		ps.setInt(8, student.getRoll());
		int execute=ps.executeUpdate();
		if(execute>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int roll) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	@Override
	public Student findStudentById(int roll) throws SQLException {
		// TODO Auto-generated method stub
		
			Statement statement=new ConnectDatabase().getConnection().createStatement();
			ResultSet rs=statement.executeQuery("select * from student where roll="+roll);
			if(rs!=null && rs.next()) {
				Student s=new Student();
				s.setRoll(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setAge(rs.getInt(5));
				s.setPassword(rs.getString(6));
				s.setPhone(rs.getLong(7));
				return s;
			}
		
		return null;
		
	}

	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
