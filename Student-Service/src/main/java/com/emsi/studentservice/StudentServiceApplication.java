package com.emsi.studentservice;

import com.emsi.studentservice.dtos.StudentInputDto;
import com.emsi.studentservice.enums.Gender;
import com.emsi.studentservice.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	//@Bean
	CommandLineRunner clr(StudentService service) {
		return args -> {
			for (int i = 0; i < 101; i++) {
				StudentInputDto studentInputDto = new StudentInputDto();
				studentInputDto.setFirstName("Student"+i+"Firstname");
				studentInputDto.setLastName("Student"+i+"Lastname");
				studentInputDto.setBirthDate(new Date());
				studentInputDto.setNic("Student"+i+"NIC");
				studentInputDto.setGender(Math.random() * 10 > 5 ? Gender.MALE : Gender.FEMALE);
				studentInputDto.setAddress("Student" + i + "Address");
				studentInputDto.setAccessYear(new Date());
				studentInputDto.setEmail("Student" + i + "@emsi-edu.com");
				studentInputDto.setPhoneNumber("+212 6 00000000");
				service.addStudent(studentInputDto);
			}
		};
	}
}
