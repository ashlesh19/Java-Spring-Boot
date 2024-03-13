package com.ashlesh.jobfinder.repository;

import com.ashlesh.jobfinder.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
