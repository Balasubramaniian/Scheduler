package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ReportService;
import com.example.demo.entity.Report;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportController {
	
	@Autowired
	private ReportService service;

	@PostMapping("/save")
	public void saveReport(@RequestBody List<Report>  report) {
		service.saveReport(report);
	}
	
	@GetMapping("/get")
	public List<Report> getReport(){
		return service.getReport();
	}
	
	@GetMapping("/export")
	public void export(HttpServletResponse reponse) throws IOException {
		service.exportData(reponse);
	}
	
	
}
