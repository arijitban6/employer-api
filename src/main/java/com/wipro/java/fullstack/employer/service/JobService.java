package com.wipro.java.fullstack.employer.service;

import com.wipro.java.fullstack.employer.entity.JobEntity;
import com.wipro.java.fullstack.employer.model.JobTopLevel;

public interface JobService {

    JobEntity createJob(JobTopLevel jobEntity);
    JobEntity deleteJob(String jobId);
    JobTopLevel getJobById(String jobId);
}
