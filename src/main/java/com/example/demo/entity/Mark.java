package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mark {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private long marks;
	private String subjectName;
	private long studentId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMarks() {
		return marks;
	}
	public void setMarks(long marks) {
		this.marks = marks;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mark(long id, long marks, String subjectName, long studentId) {
		super();
		this.id = id;
		this.marks = marks;
		this.subjectName = subjectName;
		this.studentId = studentId;
	}
	
	
	
	
	
}
