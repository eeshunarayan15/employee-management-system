package com.micro.account.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConiguration {
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
