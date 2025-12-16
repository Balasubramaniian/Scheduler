package com.example.demo.schdulerJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Email.EmailService;


@Component
public class SchdulerJob implements Job{
	
	@Autowired
	SchdulerService service;
	
	 @Autowired
	 EmailService emailService;


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
	
		  
		 String res=service.runReportTask();
		 
		 String response = service.runReportTask();
		 
		 

	        emailService.sendMail(
	                "Scheduler Job Report",
	                response
	        );
		 
		 
	}

}
