package com.example.employeeManagementSystem.repo;

import com.example.employeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
