package com.example.time_tracker.repository;

import com.example.time_tracker.entity.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
}