package com.micro.employee.controller;
import com.micro.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.micro.employee.dto.EmployeeDto;
import com.micro.employee.entites.Employee;
import com.micro.employee.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    //save employee
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        ApiResponse<Employee> saveEmployee = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);
    }
    //getAll employee
    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployee() {
        ApiResponse<List<Employee>> allEmployee = employeeService.getAllEmployee();
        return ResponseEntity.status(HttpStatus.OK).body(allEmployee);
    }
    // get single employee
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getSingleEmployee(@PathVariable  String id) {
        ApiResponse<Employee> res = employeeService.getSingleEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }
}
