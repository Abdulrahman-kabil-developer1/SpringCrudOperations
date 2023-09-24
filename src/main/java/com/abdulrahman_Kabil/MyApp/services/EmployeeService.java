package com.abdulrahman_Kabil.MyApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abdulrahman_Kabil.MyApp.models.Employee;


@Service
public interface EmployeeService {
    List < Employee > getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
}
