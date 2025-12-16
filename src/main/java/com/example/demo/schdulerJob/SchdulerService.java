package com.example.demo.schdulerJob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Quartz;

@Service
public class SchdulerService {
	
	@Autowired
	private Schduledao dao;
	
	@Autowired
    private RestTemplate restTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(SchdulerService.class);
	

	public String getCron(String reportCode) {
		String cron = dao.getCron(reportCode);
		return cron;
	}
	
	public Quartz getJobDetails() {
		Quartz quartz = dao.getJobDetails().get(0);
		return quartz;
	}
	
	
	public String runReportTask() {
		
		String reportCode = this.getJobDetails().getCode();
		
		String url =dao.getUrl(reportCode);
		
		 String response = restTemplate.getForObject(url, String.class);
         log.info("URL Response from DataBase: {}", response);
         return response;
	}
       
	
}
