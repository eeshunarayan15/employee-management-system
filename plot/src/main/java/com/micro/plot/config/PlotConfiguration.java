package com.micro.plot.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlotConfiguration {
    @Bean
    public ModelMapper getModelMapper(){
        return  new ModelMapper();
    }
}
