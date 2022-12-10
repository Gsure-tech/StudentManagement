package com.example.student_manage_demo.controller;

import com.example.student_manage_demo.dto.SubjectRequestDto;
import com.example.student_manage_demo.dto.SubjectResponseDto;
import com.example.student_manage_demo.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping("/createSubject")
    public ResponseEntity<String> createSubject(SubjectRequestDto subjectRequestDto, Long id){
       subjectService.createSubject(subjectRequestDto,id);
       return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
    }
}
