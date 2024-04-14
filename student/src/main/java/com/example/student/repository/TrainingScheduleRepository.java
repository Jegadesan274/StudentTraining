package com.example.student.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.student.entity.TrainingSchedule;

@Repository
public interface TrainingScheduleRepository extends CrudRepository<TrainingSchedule, Long> {


}
