package com.ashlesh.jobfinder.controller;

import com.ashlesh.jobfinder.model.Job;
import com.ashlesh.jobfinder.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//sets base URL
//@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;



    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);

    }


    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added",HttpStatus.CREATED);
    }


    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job =  jobService.getJobById(id);
        if(job!= null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean jobdelted = jobService.deleteJobById(id);
        if(jobdelted) {
            return new ResponseEntity<>("Deletion Success", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Deletion failed:", HttpStatus.NOT_FOUND);
    }

    //@PutMapping("/jobs/{id}")  //or
    @RequestMapping(value = "/jobs/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJobById(id,updatedJob);
        if(updated) {
            return new ResponseEntity<>("Update Success", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Update failed:", HttpStatus.NOT_FOUND);
    }

}
