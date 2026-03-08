package com.pm.applicationtracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String interviewerName;
    private String notes;
    private String outcome;

    @Enumerated(EnumType.STRING)
    private InterviewType interviewType;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    public Interview() {
    }

    public Interview(LocalDate date, LocalTime time, String interviewerName, String notes, String outcome, InterviewType interviewType, Application application) {
        this.date = date;
        this.time = time;
        this.interviewerName = interviewerName;
        this.notes = notes;
        this.outcome = outcome;
        this.interviewType = interviewType;
        this.application = application;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public String getNotes() {
        return notes;
    }

    public String getOutcome() {
        return outcome;
    }

    public InterviewType getInterviewType() {
        return interviewType;
    }

    public Application getApplication() {
        return application;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public void setInterviewType(InterviewType interviewType) {
        this.interviewType = interviewType;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
