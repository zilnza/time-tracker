package com.example.timetracker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import com.example.timetracker.dto.CreateTimeEntryRequest;
import com.example.timetracker.entity.TimeEntry;
import com.example.timetracker.service.TimeEntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@Slf4j
@Tag(
    name = "Time Entries",
    description = "CRUD operations for time tracking"
)
@RestController
@RequestMapping("/time-entries")
@RequiredArgsConstructor
public class TimeEntryController {

    private final TimeEntryService service;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")

    @Operation(summary = "Create new entry")
    @PostMapping
    public TimeEntry create(@Valid @RequestBody CreateTimeEntryRequest request) {
        log.info("Creating entry: {}",
        request.getDescription());
        return service.create(request);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")

    @Operation(summary = "Get all entries")
    @GetMapping
    public List<TimeEntry> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")

    @Operation(summary = "Delete entry")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Updating entry id {}", id);
        service.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")

    @Operation(summary = "Update entry")
    @PutMapping("/{id}")
    public TimeEntry update(
            @PathVariable Long id,
            @Valid @RequestBody CreateTimeEntryRequest request
    ) {
        log.info("Updating entry id {}", id);
        return service.update(id, request);
    }
}