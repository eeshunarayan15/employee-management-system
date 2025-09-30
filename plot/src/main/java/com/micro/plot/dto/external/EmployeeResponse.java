package com.micro.plot.dto.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
