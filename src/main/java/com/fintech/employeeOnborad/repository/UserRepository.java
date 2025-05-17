package com.fintech.employeeOnborad.repository;

import com.fintech.employeeOnborad.model.Employee;
import com.fintech.employeeOnborad.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User findByEmail(String emailAddress);


    User findByUsername(String username);
}




