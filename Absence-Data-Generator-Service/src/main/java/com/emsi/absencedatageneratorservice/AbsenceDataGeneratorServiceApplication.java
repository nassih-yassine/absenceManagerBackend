package com.emsi.absencedatageneratorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AbsenceDataGeneratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbsenceDataGeneratorServiceApplication.class, args);
	}

}
