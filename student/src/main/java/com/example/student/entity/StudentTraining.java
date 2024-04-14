package com.example.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "option")
public class StudentTraining {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Student student;

	@ManyToOne
	private TrainingSchedule trainingSchedule;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TrainingSchedule getTrainingSchedule() {
		return trainingSchedule;
	}

	public void setTrainingSchedule(TrainingSchedule trainingSchedule) {
		this.trainingSchedule = trainingSchedule;
	}

	public StudentTraining(Long id, Student student, TrainingSchedule trainingSchedule) {
		super();
		this.id = id;
		this.student = student;
		this.trainingSchedule = trainingSchedule;
	}

	public StudentTraining() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
