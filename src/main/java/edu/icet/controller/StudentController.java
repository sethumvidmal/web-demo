package edu.icet.controller;

import edu.icet.dto.StudentDTO;
import edu.icet.entity.StudentEntity;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get-all-students")
    public Iterable<StudentEntity> getStudent() {
        return studentService.getStudent();
    }
    @GetMapping("/get-student-count")
    public int getStudentCount(){
        return studentService.getStudentCount();
    }
    @GetMapping("/{firstName}")
    public Iterable<StudentEntity> getStudentByFirstName(String name) {
        return studentService.getStudentByFirstName(name);
    }

    @PostMapping
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
    }

}
