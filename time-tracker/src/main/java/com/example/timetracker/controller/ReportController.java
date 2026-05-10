package com.example.timetracker.controller;

import com.example.timetracker.dto.ReportResponse;
import com.example.timetracker.service.TimeEntryService;
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