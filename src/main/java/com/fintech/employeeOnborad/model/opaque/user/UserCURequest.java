package com.fintech.employeeOnborad.model.opaque.user;

import com.fintech.employeeOnborad.model.User;
import lombok.Data;

@Data

public class UserCURequest {

    private String username;
    private String email;
    private String password;
    private String role;
    private boolean active;


    public User buildUserModel(){
        return User.builder()
                .username(username)
                .email(email)
                .password(password)
                .role(role)
                .active(active)
                .build();
    }
}
