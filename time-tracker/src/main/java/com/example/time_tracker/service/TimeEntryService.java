package com.example.time_tracker.service;

import com.example.time_tracker.dto.ReportResponse;
import com.example.time_tracker.entity.TaskType;

import java.util.List;
import com.example.time_tracker.dto.CreateTimeEntryRequest;
import com.example.time_tracker.entity.TimeEntry;
import com.example.time_tracker.repository.TimeEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor

public class TimeEntryService {



    private final TimeEntryRepository repository;

    public TimeEntry create(CreateTimeEntryRequest request) {

        TimeEntry entry = new TimeEntry();

        entry.setDescription(request.getDescription());
        entry.setStartTime(request.getStartTime());
        entry.setEndTime(request.getEndTime());
        entry.setTaskType(request.getTaskType());

        double hours =
                Duration.between(
                        request.getStartTime(),
                        request.getEndTime()
                ).toHours();

        entry.setHoursSpent(hours);

        return repository.save(entry);
    }
    public ReportResponse getSummary() {

        List<TimeEntry> entries = repository.findAll();

        double total = 0;
        double development = 0;
        double testing = 0;

        for (TimeEntry entry : entries) {

            total += entry.getHoursSpent();

            if (entry.getTaskType() == TaskType.DEVELOPMENT) {
                development += entry.getHoursSpent();
            }

            if (entry.getTaskType() == TaskType.TESTING) {
                testing += entry.getHoursSpent();
            }
        }

        ReportResponse response = new ReportResponse();

        response.setTotalHours(total);
        response.setDevelopmentHours(development);
        response.setTestingHours(testing);

        return response;
    }
}