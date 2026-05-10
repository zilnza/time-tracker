package com.example.timetracker.dto;

import lombok.Data;

@Data
public class ReportResponse {

    private Double totalHours;
    private Double developmentHours;
    private Double testingHours;
}