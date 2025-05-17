package com.fintech.employeeOnborad.repository;

import com.fintech.employeeOnborad.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}




