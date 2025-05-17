package com.fintech.employeeOnborad.model.opaque;

import com.fintech.employeeOnborad.constants.EmployeeStatus;
import lombok.Data;

@Data
public class StatusUpdateRequest {
    private long id;
    private EmployeeStatus status;
}
