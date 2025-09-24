package com.micro.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @NotBlank(message = "Name can not be blank")
    @Size(min = 2,max = 30,message = "Name must be between 2 and 30 characters")
    private  String name;
    @NotBlank(message = "Address can not be blank")
    @Size(min = 5,max = 300,message = "Address must be between 5 and 300 characters")

    private  String address;
    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be positive")
    private  double sallary;
}
