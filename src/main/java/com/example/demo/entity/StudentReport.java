package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	private String reportCode;
	private String studentName;
	private Long mobileNo;
	private String address;
	// private List<Mark> marks;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// public List<Mark> getMarks() {
//		return marks;
//	}
//	public void setMarks(List<Mark> marks) {
//		this.marks = marks;
//	}
	public StudentReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentReport(long studentId, String reportCode, String studentName, Long mobileNo, String address) {
		super();
		this.studentId = studentId;
		this.reportCode = reportCode;
		this.studentName = studentName;
		this.mobileNo = mobileNo;
		this.address = address;
		// this.marks = marks;
	}

}
