package com.pm.applicationtracker.controller;
import com.pm.applicationtracker.dto.InterviewRequest;
import com.pm.applicationtracker.dto.InterviewResponse;
import com.pm.applicationtracker.dto.UpdateInterviewRequest;
import com.pm.applicationtracker.service.InterviewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;


    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping
    public List<InterviewResponse> getInterviews() {
        return  interviewService.getAllInterviews();
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable Long id){
        interviewService.deleteInterview(id);

    }
    @PostMapping
    public InterviewResponse createInterview(@Valid @RequestBody InterviewRequest interviewRequest){
        return interviewService.createInterview(interviewRequest);
    }

    @PutMapping("/{id}")
    public InterviewResponse updateInterview(@PathVariable Long id,  @RequestBody UpdateInterviewRequest request){
        return interviewService.updateInterview(id, request);
    }
    @GetMapping("/{id}")
    public InterviewResponse getInterviewById(@PathVariable Long id){
        return interviewService.getInterviewById(id);
    }

    @GetMapping("/application/{applicationId}")
    public List<InterviewResponse> getInterviewsByApplication(@PathVariable Long applicationId){
        return interviewService.getInterviewsByApplication(applicationId);
    }
}
