package com.keyurpandav.jobber.controller;

import com.keyurpandav.jobber.dto.JobDto;
import com.keyurpandav.jobber.entity.Job;
import com.keyurpandav.jobber.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public JobDto create(@RequestBody Job job){
        return jobService.CreateJobPosting(job);
    }

    @GetMapping
    public List<JobDto> getAllJobs(){ return jobService.getAllJobs(); }

    @GetMapping("/user/{myid}")
    public List<JobDto> getJobsByUser(@PathVariable Long myid){
        return jobService.getjobsbyusers(myid);
    }

    @GetMapping("/{myid}")
    public JobDto getJobById(@PathVariable Long myid){
        return jobService.getjobsbyid(myid);
    }

    @DeleteMapping("/{myid}")
    public boolean deleteJobById(@PathVariable Long myid){
        return jobService.deletejobs(myid);
    }
}