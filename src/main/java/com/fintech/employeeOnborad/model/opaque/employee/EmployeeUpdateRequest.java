package com.fintech.employeeOnborad.model.opaque.employee;

import com.fintech.employeeOnborad.model.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeUpdateRequest extends EmployeeCURequest {


    private long id;

    @Override
    public Employee buildEmployeeModel(){
         var employee = super.buildEmployeeModel();
         employee.setId(id);
         return employee;
    }
}
