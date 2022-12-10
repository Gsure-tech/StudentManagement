package com.example.student_manage_demo.service.serviceImpl;

import com.example.student_manage_demo.dto.SubjectRequestDto;
import com.example.student_manage_demo.dto.StudentSignUpDto;
import com.example.student_manage_demo.exception.ResourceNotFoundException;
import com.example.student_manage_demo.models.Student;
import com.example.student_manage_demo.repositories.StudentRepository;
import com.example.student_manage_demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student studentSignUp(StudentSignUpDto studentSignUpDto) {
        Student student = new Student();
        student.setName(studentSignUpDto.getName());
        student.setEmail(studentSignUpDto.getEmail());
        student.setPassword(studentSignUpDto.getPassword());
       return studentRepository.save(student);

    }

    @Override
    public List<SubjectRequestDto> getAllStudent() {
       List<Student>students=studentRepository.findAll();
       List<SubjectRequestDto> studentResponseDtoList = new ArrayList<>();
        for (Student student:students) {
            SubjectRequestDto studentResponseDto = new SubjectRequestDto();
           studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDtoList.add(studentResponseDto);
        }
       return studentResponseDtoList;
    }

    @Override
    public SubjectRequestDto getStudent(Long studentId) {
       Student student = studentRepository.findById(studentId)
               .orElseThrow(()-> new ResourceNotFoundException("Student not found", "Enter a valid Id for this student"));

           SubjectRequestDto studentResponseDto = new SubjectRequestDto();
           studentResponseDto.setId(student.getId());
           studentResponseDto.setName(student.getName());
           studentResponseDto.setEmail(student.getEmail());
           return studentResponseDto;
       }


    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
