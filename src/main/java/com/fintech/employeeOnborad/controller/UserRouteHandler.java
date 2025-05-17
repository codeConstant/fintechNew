package com.fintech.employeeOnborad.controller;

import com.fintech.employeeOnborad.config.JwtService;
import com.fintech.employeeOnborad.model.opaque.employee.EmployeeCreateRequest;
import com.fintech.employeeOnborad.model.opaque.user.AuthRequest;
import com.fintech.employeeOnborad.model.opaque.user.AuthenticateResponse;
import com.fintech.employeeOnborad.model.opaque.user.UserCreateRequest;
import com.fintech.employeeOnborad.service.EmployeeService;
import com.fintech.employeeOnborad.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class UserRouteHandler extends BaseRoutesHandler {

    private final UserService userService;

    private final JwtService jwtService;

    public UserRouteHandler(Validator validator, UserService userService,JwtService jwtService){
        super(validator);
        this.userService = userService;
        this.jwtService =  jwtService ;
    }

    public Mono<ServerResponse> register(ServerRequest request) {
        var userCreateRequestMono = request.bodyToMono(UserCreateRequest.class);

        return userCreateRequestMono.flatMap(userCreateRequest  -> {
            var user  = userCreateRequest.buildUserModel();
            return this.successResponse( userService.saveUser(user));
        });
    }

    public Mono<ServerResponse> authenticate(ServerRequest request) {
        var authRequestMono = request.bodyToMono(AuthRequest.class);

        return authRequestMono.flatMap(authRequest -> {

            var user = userService.findByEmail(authRequest.getEmail());

            UserDetails userDetails  = new User(user.getUsername(),
                    user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));

            var token  = jwtService.generateToken(userDetails);
            return this.successResponse(new AuthenticateResponse(token));
        }) ;
    }
}
