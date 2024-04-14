package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.StudentTraining;

@Repository
public interface StudentTrainingRepository extends JpaRepository<StudentTraining, Long> {

}
