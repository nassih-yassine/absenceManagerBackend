package com.emsi.studentservice.web;

import com.emsi.studentservice.dtos.StudentInputDto;
import com.emsi.studentservice.dtos.StudentOutputDto;
import com.emsi.studentservice.exceptions.IncompleteInformations;
import com.emsi.studentservice.exceptions.StudentNICExistException;
import com.emsi.studentservice.exceptions.StudentNotFoundException;
import com.emsi.studentservice.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")

public class StudentRestController {

    private StudentService studentService;

    @PostMapping("/student")
    public StudentOutputDto addStudent(@RequestBody StudentInputDto studentInputDto) throws IncompleteInformations, StudentNICExistException {
        return studentService.addStudent(studentInputDto);
    }

    @PutMapping("/student/{studentId}")
    public StudentOutputDto updateStudent(@PathVariable String studentId,@RequestBody StudentInputDto studentInputDto) throws StudentNotFoundException, IncompleteInformations {
        return  studentService.updateStudent(studentId,studentInputDto) ;
    }

    @DeleteMapping("/student/{studentId}")
    public void  deleteStudent(@PathVariable String studentId) throws StudentNotFoundException {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/students")
    public List<StudentOutputDto> studentList(){
        return studentService.studentList();
    }

    @GetMapping("/student/{studentId}")
    public StudentOutputDto searchStudent(@PathVariable String studentId) throws StudentNotFoundException {
        return studentService.searchStudent(studentId);
    }

}
