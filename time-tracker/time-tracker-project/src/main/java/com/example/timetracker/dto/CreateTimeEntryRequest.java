package com.example.timetracker.dto;

import com.example.timetracker.entity.TaskType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTimeEntryRequest {

    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private TaskType taskType;
}