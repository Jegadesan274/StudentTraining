package com.example.student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.student.entity.Student;
import org.springframework.stereotype.Service;
import com.example.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public Student getStudentById(Long id) throws Exception {
		Optional<Student> studentOptional = studentRepo.findById(id);
		if (studentOptional.isPresent()) {
			return studentOptional.get();
		} else {
			throw new Exception("Student not found " + id);
		}
	}

	@Override
	public List<Student> getAllStudents() {
		Iterable<Student> iterable = studentRepo.findAll();
		List<Student> students = new ArrayList<>();
		iterable.forEach(students::add);
		return students;
	}

	@Override
	public Student createStudent(Student student) throws Exception {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Long id, Student student) throws Exception {
		Optional<Student> studentObjOptional = studentRepo.findById(id);
		if (studentObjOptional.isPresent()) {
			Student existingStudent = studentObjOptional.get();
			existingStudent.setFirstname(student.getFirstname());
			existingStudent.setLastname(student.getLastname());
			existingStudent.setEmailId(student.getEmailId());
			existingStudent.setPassword(student.getPassword());
			return studentRepo.save(existingStudent);
		} else {
			throw new Exception("Student not found");
		}
	}

	@Override
	public Map<String, Long> deleteStudent(Long id) throws Exception {
		Student existingStudent = getStudentById(id);
		studentRepo.delete(existingStudent);
		Map<String, Long> response = new HashMap<>();
		response.put("deletedStudentId", id);
		return response;

	}
}
