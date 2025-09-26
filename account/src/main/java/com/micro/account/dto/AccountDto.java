package com.micro.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @NotBlank(message = "Account number is required")
    @Pattern(regexp = "\\d{16}", message = "Account Number must be exactly 16 digits")
    private String accountNo;

    @NotBlank(message = "Bank Name  is required")
    @Size(min = 2,max = 100,message = "Bank name must be between 2 and 100 characters")
    private  String bankName;
    @NotBlank(message = "IFSC is required")
    @Size(min = 2, max = 100, message = "IFSC must be between 2 and 100 characters")
    private  String ifsc;
    @NotBlank(message = "Address is required")
    @Size(min = 2, max = 100, message = "Address must be between 2 and 100 characters")
    private String address;
    @NotBlank(message = "EmployeeId is required")
    private  String employeeId;
}
