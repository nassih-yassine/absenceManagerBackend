package com.emsi.professorservice;

import com.emsi.professorservice.dtos.ProfessorInputDto;
import com.emsi.professorservice.enums.Sex;
import com.emsi.professorservice.services.ProfessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfessorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfessorServiceApplication.class, args);
    }

    //@Bean
    CommandLineRunner clr(ProfessorService service){
        return args -> {
            for(int i=0; i<5; i++){
                ProfessorInputDto professor = new ProfessorInputDto();
                professor.setFirstname("Professor"+i+"Firstname");
                professor.setLastname("Professor"+i+"Lastname");
                professor.setNic("Professor"+i+"NIC");
                professor.setSex(Math.random() *10 > 5 ? Sex.FEMALE : Sex.MALE);
                professor.setAddress("Professor"+i+"Address");
                professor.setEmail("Professor"+i+"@emsi-prof.com");
                professor.setPhoneNumber("+212 6 00000000");
                service.createProfessor(professor);
            }
        };
    }
}
