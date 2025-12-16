package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quartz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String cron;
	private String uniqueCode;
	private String code;
	private String configType;
	private String startTime;
	private String status;
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getConfigType() {
		return configType;
	}
	public void setConfigType(String configType) {
		this.configType = configType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Quartz(long id, String cron, String uniqueCode, String code, String configType, String startTime,
			String status) {
		super();
		this.id = id;
		this.cron = cron;
		this.uniqueCode = uniqueCode;
		this.code = code;
		this.configType = configType;
		this.startTime = startTime;
		this.status = status;
	}
	public Quartz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
