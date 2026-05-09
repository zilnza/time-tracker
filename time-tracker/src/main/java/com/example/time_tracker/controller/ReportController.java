package com.example.time_tracker.controller;

import com.example.time_tracker.dto.ReportResponse;
import com.example.time_tracker.service.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class ReportController {

    private final TimeEntryService service;

    @GetMapping("/reports/summary")
    public ReportResponse getSummary() {
        return service.getSummary();
    }
}