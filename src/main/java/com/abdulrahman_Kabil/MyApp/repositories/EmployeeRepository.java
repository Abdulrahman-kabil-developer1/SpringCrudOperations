package com.abdulrahman_Kabil.MyApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abdulrahman_Kabil.MyApp.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>  {
    
}
