package com.micro.plot.external.client;


import com.micro.plot.dto.external.EmployeeResponse;
import com.micro.plot.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "employee",
        url = "http://localhost:8081/api/employees/"
)
public interface EmployeeClient {
    //infrastructure configuration
    @GetMapping("/{id}")
    public ApiResponse<EmployeeResponse> getSingleEmployee(@PathVariable String id) ;
}
