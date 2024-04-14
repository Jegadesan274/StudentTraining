package com.example.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.dto.StudentTrainingDTO;
import com.example.student.entity.Student;
import com.example.student.entity.StudentTraining;
import com.example.student.entity.TrainingSchedule;
import com.example.student.repository.StudentRepository;
import com.example.student.repository.StudentTrainingRepository;
import com.example.student.repository.TrainingScheduleRepository;

@Service
public class StudentTrainingServiceImpl implements StudentTrainingService {
	
	@Autowired
    private StudentTrainingRepository studentTrainingRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TrainingScheduleRepository trainingScheduleRepository;

    public StudentTraining optForTraining(StudentTrainingDTO studentTrainingDTO) {
        Student student = studentRepository.findById(studentTrainingDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found: " + studentTrainingDTO.getStudentId()));

        TrainingSchedule trainingSchedule = trainingScheduleRepository.findById(studentTrainingDTO.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Training schedule not: " + studentTrainingDTO.getScheduleId()));
        StudentTraining studentTraining = new StudentTraining();
        studentTraining.setStudent(student);
        studentTraining.setTrainingSchedule(trainingSchedule);

        return studentTrainingRepository.save(studentTraining);
    }

    public List<StudentTraining> getStudentTrainings(Iterable<Long> studentId) {
        return studentTrainingRepository.findAllById(studentId);
    }

    public List<StudentTraining> getTrainingStudents(Iterable<Long> trainingScheduleId) {
        return studentTrainingRepository.findAllById(trainingScheduleId);
    }

	
}
