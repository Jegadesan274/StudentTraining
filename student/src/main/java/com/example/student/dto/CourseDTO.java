package com.example.student.dto;

public class CourseDTO {

	private int id;
    private String name;
    private String description;
    private String instructor;
    private int durationInHours;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public CourseDTO(int id, String name, String description, String instructor, int durationInHours) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.instructor = instructor;
		this.durationInHours = durationInHours;
	}
	public CourseDTO() {
		super();
	}
	
}
