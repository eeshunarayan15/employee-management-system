package com.micro.plot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class PlotApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlotApplication.class, args);
	}

}
