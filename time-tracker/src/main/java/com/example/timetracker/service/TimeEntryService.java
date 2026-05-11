package com.example.timetracker.service;

import com.example.timetracker.dto.CreateTimeEntryRequest;
import com.example.timetracker.dto.ReportResponse;
import com.example.timetracker.entity.TaskType;
import com.example.timetracker.entity.TimeEntry;
import com.example.timetracker.repository.TimeEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

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

        double hours = Duration.between(
                request.getStartTime(),
                request.getEndTime()
        ).toHours();

        entry.setHoursSpent(hours);

        return repository.save(entry);
    }

    public List<TimeEntry> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public TimeEntry update(Long id, CreateTimeEntryRequest request) {

        TimeEntry entry = repository.findById(id)
                .orElseThrow();

        entry.setDescription(request.getDescription());
        entry.setStartTime(request.getStartTime());
        entry.setEndTime(request.getEndTime());
        entry.setTaskType(request.getTaskType());

        double hours = Duration.between(
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