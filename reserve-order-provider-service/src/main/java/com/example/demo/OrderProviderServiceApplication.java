package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient

public class OrderProviderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProviderServiceApplication.class, args);
	}
}
