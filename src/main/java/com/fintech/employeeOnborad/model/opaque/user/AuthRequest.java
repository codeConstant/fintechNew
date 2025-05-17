package com.fintech.employeeOnborad.model.opaque.user;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
