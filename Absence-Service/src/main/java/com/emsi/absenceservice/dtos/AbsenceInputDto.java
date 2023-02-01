package com.emsi.absenceservice.dtos;

import lombok.Data;

@Data
public class AbsenceInputDto {
    private String studentId;
    private String courseId;
}
