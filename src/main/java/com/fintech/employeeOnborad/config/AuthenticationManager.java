package com.fintech.employeeOnborad.config;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {
    private final JwtService jwtService;
    private final ReactiveUserDetailsService userDetailsService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.justOrEmpty(authentication).cast(BearerToken.class).flatMap(bearerToken -> {
            try {
                String username = jwtService.extractUsername(bearerToken.getCredentials());

                return userDetailsService.findByUsername(username).flatMap(userDetails -> {
                    if (jwtService.isTokenValid(bearerToken.getCredentials(), userDetails)) {
                        return Mono.just(new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities()));
                    }

                    return Mono.error(new IllegalArgumentException("Token Invalid"));
                });
            } catch (Exception ex) {
                return Mono.error(new IllegalArgumentException("Token Invalid"));
            }

        });
    }
}
