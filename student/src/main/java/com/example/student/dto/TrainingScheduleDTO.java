package com.example.student.dto;

import java.time.LocalDateTime;

public class TrainingScheduleDTO {

	 private Integer id;
	 private Long courseId;
	 private LocalDateTime startTime;
	 private LocalDateTime endTime;
	 private String location;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public TrainingScheduleDTO(Integer id, Long courseId, LocalDateTime startTime, LocalDateTime endTime,
			String location) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
	}
	public TrainingScheduleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
