package com.bank.devops.inquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApiInqSaldoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiInqSaldoApplication.class, args);
	}

}
