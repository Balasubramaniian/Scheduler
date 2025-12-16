package com.example.demo.schdulerJob;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class SchedulerConfig {
	
	 @Autowired
	 private Scheduler scheduler;

	@Autowired
	private SchdulerService service;

	@PostConstruct
	public void scheduleJobs() throws Exception {

		String reportCode = service.getJobDetails().getCode();
		String cron = service.getCron(reportCode);
		
    	if(cron == null) {
    		cron ="0/15 * * * * ?";
    	}
    	

		JobDetail jobDetail = JobBuilder.newJob(SchdulerJob.class).withIdentity("reportJob", "DEFAULT")
				.usingJobData("REPORT_CODE", reportCode).build();
 
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("reportTrigger", "DEFAULT")
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();

		scheduler.scheduleJob(jobDetail, trigger);
	}

}
