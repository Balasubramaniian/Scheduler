package com.example.demo.schduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ReportQuartzJob implements Job {

    @Autowired
    private RunningService schdulerService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        schdulerService.runReportTask();
    }
}



