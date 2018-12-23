package com.wipro.java.fullstack.employer.web.coltroller;

import com.wipro.java.fullstack.employer.model.JobTopLevel;
import com.wipro.java.fullstack.employer.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    JobService jobService;

    @RequestMapping(value = "/job", method = RequestMethod.POST)
    public int createJob(@RequestBody JobTopLevel jobTopLevel) {
        jobService.createJob(jobTopLevel);
        return 0;
    }

    @RequestMapping(value = "/job/{jobId}", method = RequestMethod.DELETE)
    public int deleteJob(@PathVariable String jobId ) {
        jobService.deleteJob(jobId);
        return 0;
    }

    @RequestMapping(value = "/job/{jobId}", method = RequestMethod.GET)
    public JobTopLevel getJob(@PathVariable String jobId ) {
        return jobService.getJobById(jobId);

    }

}
