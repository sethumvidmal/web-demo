package edu.icet.controller;

import edu.icet.dto.StudentDTO;
import edu.icet.entity.StudentEntity;
import edu.icet.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tag(name = "Student information")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Operation(description = "Get all students")
    @GetMapping("/get-all-students")
    public Iterable<StudentEntity> getStudent() {
        return studentService.getStudent();
    }

    @Operation(description = "Get number of students")
    @GetMapping("/get-student-count")
    public int getStudentCount() {
        return studentService.getStudentCount();
    }

    @Operation(description = "Get existing student by first name")
    @GetMapping("/{firstName}")
    public Iterable<StudentEntity> getStudentByFirstName(String name) {
        return studentService.getStudentByFirstName(name);
    }

    @Operation(description = "Create Student in CRM System")
    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
        return studentDTO;
    }

}
