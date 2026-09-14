package com.java.graph_ql_revision.service;

import com.java.graph_ql_revision.Entity.Employee;
import com.java.graph_ql_revision.dto.EmployeeDto;
import com.java.graph_ql_revision.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employeeList = repository.findAll();

        List<EmployeeDto> employeeDtoList = employeeList
                .parallelStream()
                .map(this::mapToDto)
                .toList();
        return employeeDtoList;
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        return mapToDto(employee);
    }

    private EmployeeDto mapToDto(Employee employee) {
        return EmployeeDto
                .builder()
                .id(employee.getId())
                .name(employee.getName())
                .dept(employee.getDept())
                .salary(employee.getSalary())
                .build();
    }
}
