package com.fintech.employeeOnborad.errors;
import org.springframework.http.HttpStatus;


public record ErrorCompact(
        HttpStatus status,
        String errorMessage,
        String localizedMessage,
        Throwable cause,
        Object details) {}