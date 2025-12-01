package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String reportCode;
	private String reportName;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReportCode() {
		return reportCode;
	}
	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public Report() {
		super();
	}
	public Report(long id, String reportCode, String reportName) {
		super();
		this.id = id;
		this.reportCode = reportCode;
		this.reportName = reportName;
	}
	
	
	
	

}
