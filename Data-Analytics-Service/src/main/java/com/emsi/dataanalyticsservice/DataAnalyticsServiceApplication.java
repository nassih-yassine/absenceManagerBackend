package com.emsi.dataanalyticsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DataAnalyticsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAnalyticsServiceApplication.class, args);
    }

}
