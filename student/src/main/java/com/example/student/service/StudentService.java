package com.example.student.service;

import java.util.List;
import java.util.Map;

import com.example.student.entity.Student;

public interface StudentService {

	public Student getStudentById(Long id) throws Exception;
	public Student createStudent(Student student) throws Exception;
	public Student updateStudent(Long id, Student student) throws Exception;
	public Map<String, Long> deleteStudent(Long id) throws Exception;
	public List<Student> getAllStudents() throws Exception;

}
