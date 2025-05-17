package com.fintech.employeeOnborad.model.opaque;

import lombok.Data;

import java.util.List;

@Data
public class AssignTaskRequest {
    private Long employeeId;
    private List<TaskRequest> tasks;
}
