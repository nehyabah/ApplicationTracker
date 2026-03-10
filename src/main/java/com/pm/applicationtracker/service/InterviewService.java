package com.pm.applicationtracker.service;

import com.pm.applicationtracker.dto.InterviewRequest;
import com.pm.applicationtracker.dto.InterviewResponse;
import com.pm.applicationtracker.model.Interview;
import com.pm.applicationtracker.repository.ApplicationRepository;
import com.pm.applicationtracker.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final ApplicationRepository applicationRepository;


    @Autowired
    public InterviewService(InterviewRepository interviewRepository, ApplicationRepository applicationRepository, CompanyService companyService) {
        this.interviewRepository = interviewRepository;
        this.applicationRepository = applicationRepository;
    }

    public List<InterviewResponse> getAllInterviews(){
        return interviewRepository.findAll().stream().map(this::toResponse).toList();

    }

    public InterviewResponse getInterviewByIdOrThrow(long id){
        return null;
    }

//    public InterviewResponse createInterview(InterviewRequest request){
//        Interview interview = new Interview(
//                request.date(),
//                request.time(),
//                request.interviewerName(),
//                request.interviewType(),
//                request.
//        );
//    }



    private InterviewResponse toResponse(Interview interview) {
        return new InterviewResponse(
                interview.getId(),
                interview.getDate(),
                interview.getTime(),
                interview.getInterviewerName(),
                interview.getNotes(),
                interview.getOutcome(),
                interview.getInterviewType().name(),
                interview.getApplication().getPosition()
        );
    }

}
