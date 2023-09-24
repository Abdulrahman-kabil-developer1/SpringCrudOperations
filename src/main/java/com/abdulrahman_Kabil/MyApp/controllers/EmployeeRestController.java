package com.abdulrahman_Kabil.MyApp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdulrahman_Kabil.MyApp.models.Employee;
import com.abdulrahman_Kabil.MyApp.services.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeID){
        Employee employee = employeeService.getEmployeeById(employeeID);
        return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
    }
    
    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee , HttpStatus.CREATED );
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeID,@RequestBody Employee employee){
        employee.setId(employeeID);
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteEmployee (@PathVariable ("id" )Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity <> ("Deleted Successfully",HttpStatus.OK);
    }

}