package com.micro.account.external.client;

import com.micro.account.dto.external.EmployeeResponse;
import com.micro.account.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(
//        name = "employee",
//        url = "http://localhost:8081/api/employees/"
//)
@FeignClient(
        name = "EMPLOYEE"
)
public interface EmployeeClient {
    //infrastructure configuration
    @GetMapping("api/employees/{id}")
    public ApiResponse<EmployeeResponse> getSingleEmployee(@PathVariable String id) ;
}
