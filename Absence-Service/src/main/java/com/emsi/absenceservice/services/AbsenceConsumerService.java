package com.emsi.absenceservice.services;


import com.emsi.absenceservice.dtos.AbsenceInputDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class AbsenceConsumerService {
    private AbsenceService absenceService;
    @Bean
    Consumer<AbsenceInputDto> absenceDataConsumer(){
        return (input) -> {
            try {
                absenceService.addAbsence(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
