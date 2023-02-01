package com.emsi.staffservice.entities;

import com.emsi.staffservice.enums.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Staff {
    @Id
    private String staffId;
    private String firstname;
    private String lastname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String nic; //National Identity Card
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String address;
    private String email;
    private String phoneNumber;

}
