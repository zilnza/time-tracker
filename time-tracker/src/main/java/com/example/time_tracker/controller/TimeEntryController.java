package com.example.time_tracker.controller;

import com.example.time_tracker.dto.CreateTimeEntryRequest;
import com.example.time_tracker.entity.TimeEntry;
import com.example.time_tracker.service.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time-entries")
@RequiredArgsConstructor

public class TimeEntryController {

    private final TimeEntryService service;

    @PostMapping
    public TimeEntry create(
            @RequestBody CreateTimeEntryRequest request
    ) {
        return service.create(request);
    }
}