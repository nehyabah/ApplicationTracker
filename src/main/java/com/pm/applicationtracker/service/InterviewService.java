package com.pm.applicationtracker.service;

import com.pm.applicationtracker.dto.InterviewRequest;
import com.pm.applicationtracker.dto.InterviewResponse;
import com.pm.applicationtracker.dto.UpdateInterviewRequest;
import com.pm.applicationtracker.exception.ResourceNotFoundException;
import com.pm.applicationtracker.model.Application;
import com.pm.applicationtracker.model.Interview;
import com.pm.applicationtracker.model.InterviewType;
import com.pm.applicationtracker.repository.ApplicationRepository;
import com.pm.applicationtracker.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final ApplicationService applicationService;


    @Autowired
    public InterviewService(InterviewRepository interviewRepository,  ApplicationService applicationService) {
        this.interviewRepository = interviewRepository;
        this.applicationService = applicationService;
    }

    public List<InterviewResponse> getAllInterviews(){
        return interviewRepository.findAll().stream().map(this::toResponse).toList();

    }

    private Interview findInterviewOrThrow(Long id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Interview not found with id: " + id));
    }

    public InterviewResponse getInterviewById(Long id) {
        return toResponse(findInterviewOrThrow(id));
    }

    public InterviewResponse createInterview(InterviewRequest request) {
        Application application = applicationService.findApplicationOrThrow(request.applicationId());
        InterviewType type = InterviewType.valueOf(request.interviewType().toUpperCase());

        Interview interview = new Interview(
                request.date(),
                request.time(),
                request.interviewerName(),
                request.notes(),
                null,
                type,
                application
        );

        Interview saved = interviewRepository.save(interview);
        return toResponse(saved);
    }

    public List<InterviewResponse> getInterviewsByApplication(Long applicationId) {
        return interviewRepository.findByApplicationId(applicationId).stream()
                .map(this::toResponse)
                .toList();
    }

    public void deleteInterview(Long id) {
        findInterviewOrThrow(id);
        interviewRepository.deleteById(id);
    }

    public InterviewResponse updateInterview(Long id, UpdateInterviewRequest request) {
        Interview interview = findInterviewOrThrow(id);

        if (request.date() != null) {
            interview.setDate(request.date());
        }
        if (request.time() != null) {
            interview.setTime(request.time());
        }
        if (request.interviewerName() != null) {
            interview.setInterviewerName(request.interviewerName());
        }
        if (request.notes() != null) {
            interview.setNotes(request.notes());
        }
        if (request.outcome() != null) {
            interview.setOutcome(request.outcome());
        }

        Interview saved = interviewRepository.save(interview);
        return toResponse(saved);
    }

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
