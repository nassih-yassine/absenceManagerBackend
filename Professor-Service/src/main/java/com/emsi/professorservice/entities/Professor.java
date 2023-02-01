package com.emsi.professorservice.entities;


import com.emsi.professorservice.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    private String professorId;
    private String firstname;
    private String lastname;
    private String nic; //National Identity Card
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String address;
    private String email;
    private String phoneNumber;
}
