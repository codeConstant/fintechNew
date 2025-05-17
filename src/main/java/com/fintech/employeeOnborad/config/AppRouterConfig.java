package com.fintech.employeeOnborad.config;




import com.fintech.employeeOnborad.controller.EmployeeRouteHandler;
import com.fintech.employeeOnborad.controller.UserRouteHandler;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration

@AllArgsConstructor
public class AppRouterConfig {

    private final EmployeeRouteHandler employeeRouteHandler;

    private final UserRouteHandler userRouteHandler;

    @Bean
    public WebProperties.Resources resources() {
        return new WebProperties.Resources();
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .POST("/employee/create", employeeRouteHandler::create)
                .PUT("/update", employeeRouteHandler::update)
                .GET("/employee/fetchOne/{id}", employeeRouteHandler::fetchOne)
                .GET("/employee/fetchAll", employeeRouteHandler::all)
                .POST("/employee/assignRole", employeeRouteHandler::assignRole)
                .POST("/employee/updateStatus", employeeRouteHandler::updateStatus)
                .POST("/employee/assignTask", employeeRouteHandler::assignTask)
                .POST("/user/register", userRouteHandler::register)
                .POST("/user/authenticate", userRouteHandler::authenticate)
                .build();
    }
}
