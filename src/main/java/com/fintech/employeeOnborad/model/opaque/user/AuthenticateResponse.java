package com.fintech.employeeOnborad.model.opaque.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticateResponse {
    private String accessToken;
}
