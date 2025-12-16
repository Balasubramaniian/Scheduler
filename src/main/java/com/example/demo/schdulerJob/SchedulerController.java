package com.example.demo.schdulerJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private QuartzControlService quartzService;

    @PostMapping("/pause")
    public String pause() throws Exception {
        quartzService.pauseJob("reportJob", "DEFAULT");
        return "Job paused";
    }

    @PostMapping("/resume")
    public String resume() throws Exception {
        quartzService.resumeJob("reportJob", "DEFAULT");
        return "Job resumed";
    }

    @PostMapping("/stop")
    public String stop() throws Exception {
        quartzService.stopScheduler();
        return "Scheduler stopped";
    }

    @PostMapping("/start")
    public String start() throws Exception {
        quartzService.startScheduler();
        return "Scheduler started";
    }
}
