package com.abdulrahman_Kabil.MyApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdulrahman_Kabil.MyApp.models.Employee;
import com.abdulrahman_Kabil.MyApp.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List <Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee=optional.get();
            this.employeeRepository.delete(employee);
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub;
        Employee existingEmployee = getEmployeeById(employee.getId());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        saveEmployee(existingEmployee);
        return existingEmployee;
    }
    
}
