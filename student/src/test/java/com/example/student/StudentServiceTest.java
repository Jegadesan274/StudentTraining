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

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentServiceImpl;

public class StudentServiceTest {

	@Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStudentById() throws Exception {
        Student mockStudent = new Student();
        mockStudent.setStud_id(1L);
        mockStudent.setFirstname("John");
        mockStudent.setLastname("britto");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(mockStudent));

        Student result = studentService.getStudentById(1L);

        assertNotNull(result);
        assertEquals("John", result.getFirstname());
        assertEquals("britto", result.getLastname());
    }

}
