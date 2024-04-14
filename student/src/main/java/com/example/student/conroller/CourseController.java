package com.example.student.conroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.example.student.entity.Course;
import com.example.student.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/getid/{id}")
	public ResponseEntity<Map<String, Object>> getCourseById(@PathVariable("id") Long id) throws Exception {
		Optional<Course> course = courseService.getCourseById(id);
		Map<String, Object> response = new HashMap<>();
		response.put("course", course);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getAllCourse")
    public ResponseEntity<Map<String, Object>> getAllCourse() throws Exception {
        List<Course> courses = courseService.getAllCourses();
        Map<String, Object> response = new HashMap<>();
        response.put("courses", courses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@PostMapping("/addCourse")
	public ResponseEntity<?> createCourse(@RequestBody Course course) throws Exception {
		Course createdCourse = courseService.createCourse(course);
		return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
	}

	@PutMapping("/updateCourse/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable("id") Long id, @RequestBody Course course) throws Exception {
		Course updatedCourse = courseService.updateCourse(id, course);
		return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) throws Exception {
		courseService.deleteCourse(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
