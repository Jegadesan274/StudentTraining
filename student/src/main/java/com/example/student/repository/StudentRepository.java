package com.example.student.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.student.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
