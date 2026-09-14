package com.java.graph_ql_revision.service;

import com.java.graph_ql_revision.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();


    EmployeeDto findById(Long id);
}
