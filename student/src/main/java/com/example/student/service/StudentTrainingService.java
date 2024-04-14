package com.example.student.service;

import java.util.List;
import com.example.student.dto.StudentTrainingDTO;
import com.example.student.entity.StudentTraining;

public interface StudentTrainingService {

	StudentTraining optForTraining(StudentTrainingDTO studentTrainingDTO);
	List<StudentTraining> getStudentTrainings(Iterable<Long> studentId);
	List<StudentTraining> getTrainingStudents(Iterable<Long> trainingScheduleId);

}
