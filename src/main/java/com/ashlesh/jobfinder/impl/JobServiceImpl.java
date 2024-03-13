package com.ashlesh.jobfinder.impl;

import com.ashlesh.jobfinder.model.Job;
import com.ashlesh.jobfinder.repository.JobRepository;
import com.ashlesh.jobfinder.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
 //   private List<Job> jobs = new ArrayList<>();
    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
      //  jobs.add(job);
        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id) {

//        for (Job job: jobs){
//            if(job.getId().equals(id)){
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean  deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()){
//            Job job = iterator.next();
//            if(job.getId().equals(id))
//            {
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;

           try {
               jobRepository.deleteById(id);
               return true;
           }
            catch (Exception e){
               return false;
            }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {

        Optional<Job> jobOptional = jobRepository.findById(id);

            if(jobOptional.isPresent()){

                Job job = jobOptional.get();

                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());

                jobRepository.save(job);

                return true;

        }
        return false;
    }
}
