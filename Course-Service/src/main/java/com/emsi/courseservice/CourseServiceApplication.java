package com.emsi.courseservice;

import com.emsi.courseservice.dtos.CourseInputDto;
import com.emsi.courseservice.dtos.CourseSimpleOutputDto;
import com.emsi.courseservice.models.Professor;
import com.emsi.courseservice.models.Student;
import com.emsi.courseservice.services.CourseService;
import com.emsi.courseservice.services.ProfessorRestClient;
import com.emsi.courseservice.services.StudentRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
@EnableFeignClients
public class CourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner clr(CourseService service,
						  ProfessorRestClient prof,
						  StudentRestClient stu) {
		return args -> {
			for (int i = 0; i < 5; i++) {
				CourseInputDto course = new CourseInputDto();
				course.setName("Course-" + i);
				course.setDescription("Course-" + i + " description");
				service.createCourse(course);
			}

			Collection<CourseSimpleOutputDto> courses = service.getAll();
			Collection<Professor> professors = prof.getAllProfessors();

			int numProf = 0;
			for (CourseSimpleOutputDto c : courses) {
				Professor p = (Professor) professors.toArray()[numProf];
				try {
					service.updateCourseProfessor(
							p.getProfessorId(),
							c.getCourseId()
					);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				numProf++;
			}

			Collection<Student> students = stu.getAll();
			for (Student s : students) {
				CourseSimpleOutputDto c1 =
						courses.stream()
								.skip((int) (courses.size() * Math.random()))
								.findFirst().get();

				service.addStudentToCourse(
						s.getStudentId(),
						c1.getCourseId()
				);
			}
		};
	}
}
