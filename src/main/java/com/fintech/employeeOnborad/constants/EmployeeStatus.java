package com.fintech.employeeOnborad.constants;

public enum EmployeeStatus {
    REGISTERED,          // Employee profile created
    DOCUMENT_PENDING,    // Waiting for document submission
    KYC_PENDING,         // KYC/background checks not completed
    KYC_VERIFIED,        // KYC successfully verified
    TASKS_ASSIGNED,      // Onboarding tasks/checklist assigned
    IN_PROGRESS,         // Actively completing onboarding
    READY_TO_ACTIVATE,   // All onboarding done, pending approval
    ACTIVE,              // Fully onboarded and active
    ON_HOLD,             // Temporarily paused (missing info, etc.)
    REJECTED,            // Failed onboarding/KYC
    INACTIVE             // No longer active (left company or disabled)
}
