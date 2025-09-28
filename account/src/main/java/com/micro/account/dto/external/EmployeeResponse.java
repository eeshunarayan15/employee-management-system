package com.micro.account.dto.external;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeResponse {
    private  String id;
    private  String name;
    private  String address;
    private  double sallary;
    private  String date;
}
