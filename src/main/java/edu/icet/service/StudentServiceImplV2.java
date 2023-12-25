package edu.icet.service;

import edu.icet.annotations.MethodStat;
import edu.icet.dto.StudentDTO;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.NativeStudentRepository;
import edu.icet.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Primary
@Service
@Slf4j
public class StudentServiceImplV2 implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    NativeStudentRepository nativeStudentRepository;
    @Autowired
    ModelMapper modelMapper;
    @MethodStat
    public Iterable<StudentEntity> getStudent() {
        return studentRepository.findAll();
    }
    @MethodStat
    public Iterable<StudentEntity> getStudentByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
    @MethodStat
    public void createStudent(StudentDTO studentDTO) {
        if (Objects.equals(studentDTO.getAge(), "") || Objects.equals(studentDTO.getFirstName(), "") || Objects.equals(studentDTO.getLastName(), "") || Objects.equals(studentDTO.getInstitute(), "") || Objects.equals(studentDTO.getBatch(), "")) {
            return;
        }
        studentRepository.save(modelMapper.map(studentDTO,StudentEntity.class));
    }
    @MethodStat
    @Override
    public int getStudentCount(){
        return nativeStudentRepository.retrieveStudentCount();
    }

}
