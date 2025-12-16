package com.example.demo.schdulerJob;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartzControlService {

    @Autowired
    private Scheduler scheduler;

    public void pauseJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        scheduler.pauseJob(jobKey);
    }

    public void resumeJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        scheduler.resumeJob(jobKey);
    }

    public void stopScheduler() throws SchedulerException {
        scheduler.shutdown(true); 
    }

    public void startScheduler() throws SchedulerException {
        if (!scheduler.isStarted()) {
            scheduler.start();
        }
    }
}
