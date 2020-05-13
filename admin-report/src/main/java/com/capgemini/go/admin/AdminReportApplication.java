package com.capgemini.go.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class AdminReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminReportApplication.class, args);
	}

}
