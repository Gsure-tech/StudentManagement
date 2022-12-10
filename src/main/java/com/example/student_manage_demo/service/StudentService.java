package com.example.student_manage_demo.service;

import com.example.student_manage_demo.dto.SubjectRequestDto;
import com.example.student_manage_demo.dto.StudentSignUpDto;
import com.example.student_manage_demo.models.Student;

import java.util.List;

public interface StudentService {
    Student studentSignUp(StudentSignUpDto studentSignUpDto);
    List<SubjectRequestDto> getAllStudent();
    SubjectRequestDto getStudent(Long studentId);
    void deleteStudent(Long studentId);
}
