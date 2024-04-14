package com.example.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.entity.TrainingSchedule;
import com.example.student.repository.TrainingScheduleRepository;

@Service
public class TrainingScheduleServiceImpl implements TrainingScheduleService {

    @Autowired
    private TrainingScheduleRepository trainingScheduleRepo;

    @Override
    public Optional<TrainingSchedule> getScheduleById(Long id) throws Exception {
        Optional<TrainingSchedule> scheduleOptional = trainingScheduleRepo.findById(id);
        if (scheduleOptional.isPresent()) {
            return scheduleOptional;
        } else {
            throw new Exception("Training schedule not found : " + id);
        }
    }

    @Override
    public TrainingSchedule createSchedule(TrainingSchedule schedule) {
        return trainingScheduleRepo.save(schedule);
    }

    @Override
    public TrainingSchedule updateSchedule(Long id, TrainingSchedule schedule) throws Exception {
        Optional<TrainingSchedule> existingScheduleOptional = trainingScheduleRepo.findById(id);
        if (existingScheduleOptional.isPresent()) {
            TrainingSchedule existingSchedule = existingScheduleOptional.get();
            existingSchedule.setCourse(schedule.getCourse());
            existingSchedule.setStartTime(schedule.getStartTime());
            existingSchedule.setEndTime(schedule.getEndTime());
            existingSchedule.setLocation(schedule.getLocation());
            return trainingScheduleRepo.save(existingSchedule);
        } else {
            throw new Exception("Training schedule not found: " + id);
        }
    }



    @Override
    public void deleteSchedule(Long id) throws Exception {
        Optional<TrainingSchedule> existingScheduleOptional = trainingScheduleRepo.findById(id);
        if (existingScheduleOptional.isPresent()) {
            trainingScheduleRepo.delete(existingScheduleOptional.get());
        } else {
            throw new Exception("Training schedule not found with id: " + id);
        }
    }


    @Override
    public List<TrainingSchedule> getAllSchedules() {
    	Iterable<TrainingSchedule> iterable = trainingScheduleRepo.findAll();
    	List<TrainingSchedule> training = new ArrayList<>();
    	iterable.forEach(training::add);
        return training;
    }

}
