package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuartzService;
import com.example.demo.entity.Quartz;

@RestController
@RequestMapping("/auto")
public class QuartzController {
	@Autowired
	private QuartzService ser;
	
	@PostMapping("/createjob")
	public void createjob(@RequestBody Quartz quartz) {
		ser.createJob(quartz);
	}
	
	

}
