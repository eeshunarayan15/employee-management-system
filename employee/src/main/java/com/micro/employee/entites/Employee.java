package com.micro.employee.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private  String id;
    @Column(length = 30)
    private  String name;
    @Column(length = 30)
    private  String address;
    @DecimalMin(value="1000.0", message = "Salary must be atleast be 1000")
    @DecimalMax(value="10000.0", message = "Salary must not exceed  10000")

    private  double sallary;
    private  String date;
}
