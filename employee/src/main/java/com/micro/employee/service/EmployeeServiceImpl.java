package com.micro.employee.service;

import com.micro.employee.dto.EmployeeDto;
import com.micro.employee.entites.Employee;
import com.micro.employee.exception.ResourceNOtFoundException;
import com.micro.employee.payload.ApiResponse;
import com.micro.employee.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;


    @Override
    public ApiResponse<List<Employee>> getAllEmployee() {
        List<Employee> employeeList = employeeRepo.findAll();
        if (employeeList.isEmpty()) {
            return new ApiResponse<>("Error", "No employee found", null);
        }
        ApiResponse<List<Employee>> response = new ApiResponse<>("Success", "Employee found", employeeList);


        return response;
    }

    @Override
    public ApiResponse<Employee> getSingleEmployee(String id) {
        Employee singleEmployee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNOtFoundException("Employee Not Found With Id : " + id));
        return new ApiResponse<>("Sucess", "Data Found", singleEmployee);
    }

    @Override
    public ApiResponse<Employee> saveEmployee(EmployeeDto employeeDto) {

        Employee emp = modelMapper.map(employeeDto, Employee.class);
        emp.setId(UUID.randomUUID().toString());
        emp.setDate(LocalDateTime.now().toString());
        Employee savedEmployee = employeeRepo.save(emp);
        return new ApiResponse<>("Sucess", "Employee saved successfully", savedEmployee);
    }
}
