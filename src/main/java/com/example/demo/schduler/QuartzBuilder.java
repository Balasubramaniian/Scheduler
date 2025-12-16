package com.example.demo.schduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class QuartzBuilder {

	
    @Bean
    public JobDetail reportJobDetail() {
        return JobBuilder.newJob(ReportQuartzJob.class)
                .withIdentity("REPORT_JOB", "REPORT_GROUP")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger reportJobTrigger(JobDetail reportJobDetail) {
    	
    	
        return TriggerBuilder.newTrigger()
                .withIdentity("REPORT_TRIGGER", "REPORT_GROUP")
                .forJob(reportJobDetail)
                .withSchedule(
                		CronScheduleBuilder.cronSchedule("0/15 * * * * ?")
                .withMisfireHandlingInstructionDoNothing()
                )
                .build();
    }
    
}
