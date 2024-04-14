package com.example.student.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/student/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) throws Exception {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() throws Exception {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

	@PostMapping("/addStudentDetails")
	public ResponseEntity<?> createStudent(@RequestBody Student student) throws Exception {
		Student createdStudent = studentService.createStudent(student);
		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}

	@PutMapping("/updateStudentDetail/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") Long id, @RequestBody Student student)
			throws Exception {
		Student updatedStudent = studentService.updateStudent(id, student);
		return new ResponseEntity<>(updatedStudent, HttpStatus.CREATED);
	}

	@DeleteMapping("deleteStudentId/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) throws Exception {
		studentService.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
