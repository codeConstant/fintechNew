package com.fintech.employeeOnborad.service;

import com.fintech.employeeOnborad.config.Messages;
import com.fintech.employeeOnborad.errors.NotFoundError;
import com.fintech.employeeOnborad.model.Employee;
import com.fintech.employeeOnborad.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

     public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundError(Messages.USER_ID_NOT_FOUND));
     }

     public List<Employee> findByAll() {
        return employeeRepository.findAll();
    }
}
