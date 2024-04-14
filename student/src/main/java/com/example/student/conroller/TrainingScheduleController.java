package com.example.student.conroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.student.entity.TrainingSchedule;
import com.example.student.service.TrainingScheduleService;

@RestController
public class TrainingScheduleController {

	@Autowired
	TrainingScheduleService scheduleService;

	@GetMapping("/getTrainingId/{id}")
	public ResponseEntity<?> getScheduleById(@PathVariable("id") Long id) throws Exception {
		Optional<TrainingSchedule> schedule = scheduleService.getScheduleById(id);
		return new ResponseEntity<>(schedule, HttpStatus.OK);
	}

	@GetMapping("/getAllTraining")
	public ResponseEntity<?> getAllSchedule() throws Exception {
		List<TrainingSchedule> course = scheduleService.getAllSchedules();
		return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
	}
	@PostMapping("/addTrainingDetails")
	public ResponseEntity<?> createSchedule(@RequestBody TrainingSchedule schedule) throws Exception {
		TrainingSchedule createdSchedule = scheduleService.createSchedule(schedule);
		return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
	}

	@PutMapping("/updateTrainingDetails/{id}")
	public ResponseEntity<?> updateSchedule(@PathVariable("id") Long id, @RequestBody TrainingSchedule schedule)
			throws Exception {
		TrainingSchedule updatedSchedule = scheduleService.updateSchedule(id, schedule);
		return new ResponseEntity<>(updatedSchedule, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteTrainingDetails/{id}")
	public ResponseEntity<?> deleteSchedule(@PathVariable("id") Long id) throws Exception {
		scheduleService.deleteSchedule(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
