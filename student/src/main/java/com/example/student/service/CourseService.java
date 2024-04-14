package com.example.student.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.example.student.entity.Course;

public interface CourseService {

	Optional<Course> getCourseById(Long id) throws Exception;
	List<Course> getAllCourses() throws Exception;
	Course createCourse(Course course) throws Exception;
	Course updateCourse(Long id, Course course) throws Exception;
	Map<String, Long> deleteCourse(Long id) throws Exception;

}
