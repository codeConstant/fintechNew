package com.fintech.employeeOnborad.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtConverter implements ServerAuthenticationConverter
{
    
    @Override
    public Mono<Authentication> convert (ServerWebExchange exchange)
    {
        return Mono.justOrEmpty(exchange.getRequest()
                                        .getHeaders()
                                        .getFirst("Authorization"))
                   .filter(s -> s.startsWith("Bearer "))
                   .map(s -> s.substring(7))
                   .map(BearerToken::new);
    }
}
