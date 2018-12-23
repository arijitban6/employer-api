package com.wipro.java.fullstack.employer.service.impl;

import com.wipro.java.fullstack.employer.entity.JobEntity;
import com.wipro.java.fullstack.employer.mapper.EntityMapper;
import com.wipro.java.fullstack.employer.mapper.TwoWayMapper;
import com.wipro.java.fullstack.employer.model.JobTopLevel;
import com.wipro.java.fullstack.employer.repository.JobRepository;
import com.wipro.java.fullstack.employer.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;
    @Autowired
    EntityMapper twoWayMapper;

    @Override
    public JobEntity createJob(JobTopLevel jobTopLevel) {

        JobEntity jobEntity = twoWayMapper.mapTo(jobTopLevel);
        jobRepository.save(jobEntity);
        return null;
    }

    @Override
    public JobEntity deleteJob(String jobId) {
        jobRepository.deleteById(Long.parseLong(jobId));
        return null;
    }

    @Override
    public JobTopLevel getJobById(String jobId) {
        return twoWayMapper.mapFrom(jobRepository.findById(Long.parseLong(jobId)).get());
    }
}
