package com.example.time_tracker.dto;

import com.example.time_tracker.entity.TaskType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTimeEntryRequest {

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private TaskType taskType;
}