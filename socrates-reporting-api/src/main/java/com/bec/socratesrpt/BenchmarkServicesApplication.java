package com.bec.socratesrpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bec.socratesrpt.*")
public class BenchmarkServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenchmarkServicesApplication.class, args);
	}
}
