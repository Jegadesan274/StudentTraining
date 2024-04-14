package com.example.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.student.entity.Course;
import com.example.student.repository.CourseRepository;
import com.example.student.service.CourseServiceImpl;

public class CourseServiceTest {

	@Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCourseById() throws Exception {
        Course mockCourse = new Course();
        mockCourse.setId(1L);
        mockCourse.setCoursename("Java");

        when(courseRepository.findById(1L)).thenReturn(Optional.of(mockCourse));

        Optional<Course> result = courseService.getCourseById(1L);

        assertNotNull(result);
        assertEquals("Java", result.get().getCoursename());
    }
}
