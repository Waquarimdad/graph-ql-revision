package com.java.graph_ql_revision.controller;

import com.java.graph_ql_revision.dto.EmployeeDto;
import com.java.graph_ql_revision.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @QueryMapping
    public List<EmployeeDto> getAllEmployee() {
       return service.findAll();
    }

    @QueryMapping
    public EmployeeDto findById(@Argument Long id) {
        return service.findById(id);
    }
}
