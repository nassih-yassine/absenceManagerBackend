package com.emsi.staffservice;


import com.emsi.staffservice.dtos.StaffInputDto;
import com.emsi.staffservice.enums.Sex;
import com.emsi.staffservice.services.StaffService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class StaffServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffServiceApplication.class, args);
    }

    //@Bean
    CommandLineRunner clr(StaffService service){
        return args -> {
            for(int i = 0; i< 10; i++){
                StaffInputDto staff = new StaffInputDto();
                staff.setFirstname("Staff" + i + "Firstname");
                staff.setLastname("Staff"+i+"Lastname");
                staff.setBirthdate(new Date());
                staff.setNic("Staff"+i+"NIC");
                staff.setSex(Math.random() * 10 > 5 ? Sex.MALE : Sex.FEMALE);
                staff.setAddress("Staff" + i+ "Address");
                staff.setEmail("Staff"+i+"@emsi-staff.com");
                staff.setPhoneNumber("+212 6 000000");
                service.createStaff(staff);
            }
        };
    }
}
