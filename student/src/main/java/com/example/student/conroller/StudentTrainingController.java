package com.example.student.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.StudentTrainingDTO;
import com.example.student.entity.StudentTraining;
import com.example.student.service.StudentTrainingService;

@RestController
public class StudentTrainingController {


    @Autowired
    private StudentTrainingService studentTrainingService;

    @PostMapping("/opt")
    public ResponseEntity<StudentTraining> optForTraining(@RequestBody StudentTrainingDTO studentTrainingDTO) {
        StudentTraining studentTraining = studentTrainingService.optForTraining(studentTrainingDTO);
        return ResponseEntity.ok(studentTraining);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentTraining>> getStudentTrainings(@PathVariable Iterable<Long> studentId) {
        List<StudentTraining> studentTrainings = studentTrainingService.getStudentTrainings(studentId);
        return ResponseEntity.ok(studentTrainings);
    }

    @GetMapping("/training/{trainingScheduleId}")
    public ResponseEntity<List<StudentTraining>> getTrainingStudents(@PathVariable Iterable<Long> trainingScheduleId) {
        List<StudentTraining> trainingStudents = studentTrainingService.getTrainingStudents(trainingScheduleId);
        return ResponseEntity.ok(trainingStudents);
    }

}
