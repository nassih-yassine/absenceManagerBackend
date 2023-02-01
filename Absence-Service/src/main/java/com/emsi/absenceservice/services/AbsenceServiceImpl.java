package com.emsi.absenceservice.services;

import com.emsi.absenceservice.dtos.AbsenceInputDto;
import com.emsi.absenceservice.dtos.AbsenceOutputDto;
import com.emsi.absenceservice.entities.Absence;
import com.emsi.absenceservice.exceptions.AbsenceIdNotFoundException;
import com.emsi.absenceservice.exceptions.CourseIdNotFoundException;
import com.emsi.absenceservice.exceptions.MissingFieldsException;
import com.emsi.absenceservice.exceptions.StudentIdNotFoundException;
import com.emsi.absenceservice.mappers.MapperService;
import com.emsi.absenceservice.repositories.AbsenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {
    private AbsenceRepository absenceRepository;
    private MapperService mapper;
    private CourseRestClient courseRestClient;
    private StudentRestClient studentRestClient;

    @Override
    public AbsenceOutputDto addAbsence(AbsenceInputDto absenceInputDto) throws Exception {
        if (absenceInputDto.getCourseId() == null || absenceInputDto.getCourseId().isEmpty()
                || absenceInputDto.getStudentId() == null || absenceInputDto.getStudentId().isEmpty())
            throw new MissingFieldsException();

        if(studentRestClient.getStudent(absenceInputDto.getStudentId()) == null)
            throw new StudentIdNotFoundException(absenceInputDto.getStudentId());

        if(courseRestClient.getCourse(absenceInputDto.getCourseId()) == null)
            throw new CourseIdNotFoundException(absenceInputDto.getCourseId());

        Absence absence = new Absence();
        absence.setId(UUID.randomUUID().toString());
        absence.setCourseId(absenceInputDto.getCourseId());
        absence.setStudentId(absenceInputDto.getStudentId());
        return mapper.fromAbsence(absenceRepository.save(absence));
    }

    @Override
    public Collection<AbsenceOutputDto> getAll() {
        return absenceRepository.findAll().stream().map(mapper::fromAbsence).toList();
    }

    @Override
    public AbsenceOutputDto getSingle(String id) throws Exception {
        Absence absence = absenceRepository.findById(id).orElseThrow(() -> new AbsenceIdNotFoundException(id));
        return mapper.fromAbsence(absence);
    }

    @Override
    public Collection<AbsenceOutputDto> getStudentAbsence(String studentId) throws Exception {
        if (studentRestClient.getStudent(studentId) == null)
            throw new StudentIdNotFoundException(studentId);
        return absenceRepository.getStudentAbsence(studentId).stream().map(mapper::fromAbsence).toList();
    }

    @Override
    public Collection<AbsenceOutputDto> getCourseAbsence(String courseId) throws Exception {
        if (courseRestClient.getCourse(courseId) == null)
            throw new CourseIdNotFoundException(courseId);
        return absenceRepository.getCourseAbsence(courseId).stream().map(mapper::fromAbsence).toList();
    }

    @Override
    public void deleteAbsence(String id) throws Exception {
        Absence absence = absenceRepository.findById(id).orElseThrow(() -> new AbsenceIdNotFoundException(id));
        absenceRepository.delete(absence);
    }
}
