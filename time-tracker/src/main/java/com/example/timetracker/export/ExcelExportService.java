package com.example.timetracker.export;

import com.example.timetracker.entity.TimeEntry;
import com.example.timetracker.repository.TimeEntryRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelExportService {

    private final TimeEntryRepository repository;

    public ByteArrayInputStream export() {

        List<TimeEntry> data = repository.findAll();

        try (XSSFWorkbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            XSSFSheet sheet = workbook.createSheet("time-report");

            int rowIndex = 0;

            XSSFRow header = sheet.createRow(rowIndex++);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Description");
            header.createCell(2).setCellValue("Hours");

            for (TimeEntry entry : data) {
                XSSFRow row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(entry.getId());
                row.createCell(1).setCellValue(entry.getDescription());
                row.createCell(2).setCellValue(entry.getHoursSpent());
            }

            workbook.write(out);

            return new ByteArrayInputStream(out.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}