package com.keyurpandav.jobber.controller;

import com.keyurpandav.jobber.dto.ApplicationDto;
import com.keyurpandav.jobber.entity.Application;
import com.keyurpandav.jobber.enums.ApplicationStatusType;
import com.keyurpandav.jobber.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ApplicationDto applyForJob(@RequestBody Application mydata){
        return applicationService.applyToJob(mydata);
    }

    @GetMapping("job/{myid}")
    private List<ApplicationDto> applicationbyjob(@PathVariable Long myid){
        return applicationService.getApplicationsByJob(myid);
    }

    @GetMapping("user/{myid}")
    private List<ApplicationDto> applicationbyusers(@PathVariable Long myid){
        return applicationService.getApplicationsByUser(myid);
    }

    @GetMapping("/job/{jobId}")
    public List<ApplicationDto> getApplicationsByJob(@PathVariable Long jobId){
        return applicationService.getApplicationsByJob(jobId);
    }

    @PutMapping("/{id}/status")
    public ApplicationDto updateApplicationStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body){

        ApplicationStatusType status = ApplicationStatusType.valueOf(
                body.get("status").toUpperCase());
        return applicationService.updateStatus(id, status);
    }

    @DeleteMapping("/me/{appId}")
    public boolean cancelMyApplication(@PathVariable Long appId){
        return applicationService.deletebyid(appId);
    }
}