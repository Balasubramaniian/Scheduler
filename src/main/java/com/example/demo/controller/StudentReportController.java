package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StudentService;
import com.example.demo.entity.StudentReport;

@RestController
@RequestMapping("/student")
public class StudentReportController {
	
	@Autowired
	private StudentService service;
	
	
	@PostMapping("/save")
	public void saveStudent(@RequestBody StudentReport report) {
		service.saveStudent(report);
	}
	
	@GetMapping("/get")
	public List<StudentReport> getStudent(){
		System.out.println("Student Details:");
		return service.getStudent();
	}

}
