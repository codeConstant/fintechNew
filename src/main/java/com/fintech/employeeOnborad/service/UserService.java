package com.fintech.employeeOnborad.service;

import com.fintech.employeeOnborad.config.Messages;
import com.fintech.employeeOnborad.errors.NotFoundError;
import com.fintech.employeeOnborad.model.Employee;
import com.fintech.employeeOnborad.model.User;
import com.fintech.employeeOnborad.repository.EmployeeRepository;
import com.fintech.employeeOnborad.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateEmployee(User user) {
        return userRepository.save(user);
    }

     public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundError(Messages.USER_ID_NOT_FOUND));
     }

     public List<User> findByAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }


    public User findByUsername(String name){
        return this.userRepository.findByUsername(name);
    }
}
