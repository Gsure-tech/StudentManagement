package com.example.student_manage_demo.service;

import com.example.student_manage_demo.dto.SubjectRequestDto;
import com.example.student_manage_demo.models.Subject;

import java.util.List;

public interface SubjectService {
    String createSubject(SubjectRequestDto subjectRequestDto, Long studentId);
    List<Subject> fetchAllStudentSubject(Long studentId);
}
