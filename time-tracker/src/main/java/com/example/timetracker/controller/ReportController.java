package com.example.timetracker.controller;

import com.example.timetracker.export.ExcelExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import com.example.timetracker.dto.ReportResponse;
import com.example.timetracker.service.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ExcelExportService excelExportService;

    @GetMapping("/reports/export")
    public ResponseEntity<InputStreamResource> export() {

        ByteArrayInputStream file = excelExportService.export();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=report.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(file));
    }
}