package com.fintech.employeeOnborad.model.opaque;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {
    private String title;
    private String description;
    private LocalDate dueDate;
}
