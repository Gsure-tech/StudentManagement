package com.example.student_manage_demo.controller;

import com.example.student_manage_demo.dto.SubjectRequestDto;
import com.example.student_manage_demo.dto.StudentSignUpDto;
import com.example.student_manage_demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody StudentSignUpDto studentSignUpDto){
   studentService.studentSignUp(studentSignUpDto);
    return new ResponseEntity<>("sign up successful", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity <List <SubjectRequestDto>> getAllStudent(){
       List <SubjectRequestDto> studentResponseDtoList = studentService.getAllStudent();
        return new ResponseEntity<>(studentResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/profile/{studentId}")
    public ResponseEntity <SubjectRequestDto> getStudent(@PathVariable Long studentId){
        SubjectRequestDto studentResponseDto = studentService.getStudent(studentId);
        return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity <String> deleteStudent (@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
    }

}
