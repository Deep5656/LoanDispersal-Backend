package com.chc.credithistorycheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CredithistorycheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredithistorycheckApplication.class, args);
	}

}
