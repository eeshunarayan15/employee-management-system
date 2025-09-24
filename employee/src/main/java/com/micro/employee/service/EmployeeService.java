package com.micro.employee.service;

import com.micro.employee.dto.EmployeeDto;
import com.micro.employee.entites.Employee;
import com.micro.employee.payload.ApiResponse;


import java.util.List;

public interface EmployeeService {
   ApiResponse<List<Employee>> getAllEmployee();
    ApiResponse<Employee>   getSingleEmployee(String id);
    ApiResponse<Employee>  saveEmployee(EmployeeDto employeeDto);

}
