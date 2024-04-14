package com.example.student.service;

import java.util.List;
import java.util.Optional;
import com.example.student.entity.TrainingSchedule;

public interface TrainingScheduleService {

	public Optional<TrainingSchedule> getScheduleById(Long id) throws Exception;
	public TrainingSchedule createSchedule(TrainingSchedule schedule) throws Exception;
	public TrainingSchedule updateSchedule(Long id, TrainingSchedule schedule) throws Exception;
	public void deleteSchedule(Long id) throws Exception;
	public List<TrainingSchedule> getAllSchedules() throws Exception;
	

}
