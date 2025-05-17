package com.fintech.employeeOnborad.model;

import com.fintech.employeeOnborad.constants.EmployeeStatus;
import com.fintech.employeeOnborad.model.opaque.employee.OnboardingTask;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private String role;
    private EmployeeStatus status;
    private String department;
    private String startDate;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<OnboardingTask> onboardingTasks = new ArrayList<>();
}
