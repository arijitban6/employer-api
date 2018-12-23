package com.wipro.java.fullstack.employer.repository;

import com.wipro.java.fullstack.employer.entity.JobEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<JobEntity,Long> {
}
