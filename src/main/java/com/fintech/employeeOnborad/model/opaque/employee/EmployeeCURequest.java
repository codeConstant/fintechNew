package com.fintech.employeeOnborad.model.opaque.employee;

import com.fintech.employeeOnborad.constants.EmployeeStatus;
import com.fintech.employeeOnborad.model.Employee;
import lombok.Data;

@Data
public class EmployeeCURequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private String department;
    private String startDate;
    private String role;
    private EmployeeStatus status;


    public Employee buildEmployeeModel(){
        return Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .department(department)
                .phone(phone)
                .position(position)
                .startDate(startDate)
                .role(role)
                .status(status)
                .build();
    }
}
