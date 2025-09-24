package com.micro.employee.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
    @Bean
    ModelMapper modelMapper (){
        return  new ModelMapper();
    }
}
