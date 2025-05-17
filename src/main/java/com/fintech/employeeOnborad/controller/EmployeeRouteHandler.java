package com.fintech.employeeOnborad.controller;

import com.fintech.employeeOnborad.model.opaque.AssignRoleRequest;
import com.fintech.employeeOnborad.model.opaque.AssignTaskRequest;
import com.fintech.employeeOnborad.model.opaque.StatusUpdateRequest;
import com.fintech.employeeOnborad.model.opaque.employee.EmployeeCreateRequest;
import com.fintech.employeeOnborad.model.opaque.employee.EmployeeUpdateRequest;
import com.fintech.employeeOnborad.model.opaque.employee.OnboardingTask;
import com.fintech.employeeOnborad.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class EmployeeRouteHandler extends BaseRoutesHandler {

    private final EmployeeService employeeService;

    public EmployeeRouteHandler(Validator validator,EmployeeService employeeService){
       super(validator);
       this.employeeService = employeeService;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        var employeeCreateRequestMono = request.bodyToMono(EmployeeCreateRequest.class);

        return employeeCreateRequestMono.flatMap(employeeCreateRequest -> {
            var employee  = employeeCreateRequest.buildEmployeeModel();
            return this.successResponse( employeeService.saveEmployee(employee));
        });
    }


    public Mono<ServerResponse> update(ServerRequest request) {
        var employeeUpdateRequestMono = request.bodyToMono(EmployeeUpdateRequest.class);
        return employeeUpdateRequestMono.flatMap(employeeUpdateRequest  -> {
            var employee  = employeeUpdateRequest.buildEmployeeModel();
            return this.successResponse(employeeService.updateEmployee(employee));
        });
    }

    public Mono<ServerResponse> fetchOne(ServerRequest request) {
        var employeeId = getPathVariableId(request);
        return this.successResponse(employeeService.findById(Long.parseLong(employeeId)));
    }

    public Mono<ServerResponse> all(ServerRequest request) {
        var employeeUpdateRequestMono = request.bodyToMono(EmployeeUpdateRequest.class);
        return employeeUpdateRequestMono.flatMap(employeeUpdateRequest  -> {
            var employee  = employeeUpdateRequest.buildEmployeeModel();
            return this.successResponse( employeeService.saveEmployee(employee));
        });
    }

    public Mono<ServerResponse> assignRole(ServerRequest request) {
        var assignRoleRequestMono = request.bodyToMono(AssignRoleRequest.class);

        return assignRoleRequestMono.flatMap(assignRoleRequest -> {
           var employee  = employeeService.findById(assignRoleRequest.getId());
            employee.setRole(assignRoleRequest.getRole());
            return this.successResponse(employeeService.saveEmployee(employee));
        });
    }


    public Mono<ServerResponse> updateStatus(ServerRequest request) {
        var statusUpdateRequestMono = request.bodyToMono(StatusUpdateRequest.class);
        return statusUpdateRequestMono.flatMap(statusUpdateRequest  -> {
            var employee  = employeeService.findById(statusUpdateRequest.getId());
            employee.setStatus(statusUpdateRequest.getStatus());
            return this.successResponse(employeeService.saveEmployee(employee));
        });
    }

    public Mono<ServerResponse> assignTask(ServerRequest request) {
        var assignTaskRequestMono = request.bodyToMono(AssignTaskRequest.class);

         return assignTaskRequestMono.flatMap(assignTaskRequest -> {

             var employee  = employeeService.findById(assignTaskRequest.getEmployeeId());

             var onboardingTaskList = assignTaskRequest.getTasks().stream()
                     .map(taskRequest -> {
                        return OnboardingTask.builder()
                                 .id(employee.getId())
                                 .description(taskRequest.getDescription())
                                 .dueDate(taskRequest.getDueDate())
                                 .title(taskRequest.getTitle())
                                 .build();
                     }).toList();

             employee.setOnboardingTasks(onboardingTaskList);

             return this.successResponse(employeeService.saveEmployee(employee));
         });
    }
}
