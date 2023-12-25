package edu.icet.service;

import edu.icet.dto.StudentDTO;
import edu.icet.entity.StudentEntity;

public interface StudentService {
    public Iterable<StudentEntity> getStudent();

    void createStudent(StudentDTO studentDTO);

    Iterable<StudentEntity> getStudentByFirstName(String firstName);
    public int getStudentCount();
}
