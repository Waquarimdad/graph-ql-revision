package com.java.graph_ql_revision.repository;

import com.java.graph_ql_revision.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
