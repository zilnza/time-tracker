package com.example.timetracker.controller;

import com.example.timetracker.dto.CreateTimeEntryRequest;
import com.example.timetracker.entity.TimeEntry;
import com.example.timetracker.service.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time-entries")
@RequiredArgsConstructor
public class TimeEntryController {

    private final TimeEntryService service;

    @PostMapping
    public TimeEntry create(@RequestBody CreateTimeEntryRequest request) {
        return service.create(request);
    }
}