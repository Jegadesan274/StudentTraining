package com.example.student.dto;

public class StudentTrainingDTO {
	private Long studentId;
	private Long scheduleId;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public StudentTrainingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentTrainingDTO(Long studentId, Long scheduleId) {
		super();
		this.studentId = studentId;
		this.scheduleId = scheduleId;
	}

}
