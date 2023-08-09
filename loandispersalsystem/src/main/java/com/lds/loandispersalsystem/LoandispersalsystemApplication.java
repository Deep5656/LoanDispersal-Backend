package com.lds.loandispersalsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoandispersalsystemApplication {
//new branch name aman
	public static void main(String[] args) {
		SpringApplication.run(LoandispersalsystemApplication.class, args);
	}
}