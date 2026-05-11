package com.example.timetracker.controller;

import com.example.timetracker.dto.CreateTimeEntryRequest;
import com.example.timetracker.entity.TimeEntry;
import com.example.timetracker.service.TimeEntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
@RequiredArgsConstructor
public class TimeEntryController {

    private final TimeEntryService service;

    @PostMapping
    public TimeEntry create(@Valid @RequestBody CreateTimeEntryRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<TimeEntry> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public TimeEntry update(
            @PathVariable Long id,
            @Valid @RequestBody CreateTimeEntryRequest request
    ) {
        return service.update(id, request);
    }
}