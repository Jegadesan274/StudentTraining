package com.example.student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.entity.Course;
import com.example.student.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepo;

	public List<Course> getAllCourses() throws Exception {
		Iterable<Course> iterable = courseRepo.findAll();
		List<Course> courses = new ArrayList<>();
		iterable.forEach(courses::add);
		return courses;
	}

	@Override
	public Course createCourse(Course course) {
		return courseRepo.save(course);
	}

	public Optional<Course> getCourseById(Long id) throws Exception {
		Optional<Course> courseOptional = courseRepo.findById(id);
		if (courseOptional.isPresent()) {
			return courseOptional;
		} else {
			throw new Exception("Course not found " + id);
		}
	}

	public Course updateCourse(Long id, Course course) throws Exception {
		Optional<Course> existingCourseOptional = courseRepo.findById(id);
		if (existingCourseOptional.isPresent()) {
			Course existingCourse = existingCourseOptional.get();
			existingCourse.setCoursename(course.getCoursename());
			existingCourse.setCoursedescription(course.getCoursedescription());
			existingCourse.setCourseinstructor(course.getCourseinstructor());
			existingCourse.setCourseduration(course.getCourseduration());
			return courseRepo.save(existingCourse);
		} else {
			throw new Exception("Course not found");
		}
	}

	public Map<String, Long> deleteCourse(Long id) throws Exception {
		Optional<Course> existingCourseOptional = courseRepo.findById(id);
		if (existingCourseOptional.isPresent()) {
			Course existingCourse = existingCourseOptional.get();
			courseRepo.delete(existingCourse);
			Map<String, Long> response = new HashMap<>();
			response.put("deletedCourseId", id);
			return response;
		} else {
			throw new Exception("Course not found");
		}
	}

}
