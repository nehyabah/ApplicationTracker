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

    @Enumerated(EnumType.STRING)
    private InterveiwType interveiwType;

}
