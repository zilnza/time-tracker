package com.example.time_tracker.dto;

import com.example.time_tracker.entity.TaskType;
import lombok.Data;

@Data
public class TimeEntryResponse {

    private Long id;

    private String description;

    private Double hoursSpent;

    private TaskType taskType;
}