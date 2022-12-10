package com.example.student_manage_demo.service.serviceImpl;

import com.example.student_manage_demo.dto.SubjectRequestDto;
import com.example.student_manage_demo.models.Student;
import com.example.student_manage_demo.models.Subject;
import com.example.student_manage_demo.repositories.StudentRepository;
import com.example.student_manage_demo.repositories.SubjectRepository;
import com.example.student_manage_demo.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public String createSubject(SubjectRequestDto subjectRequestDto, Long studentId) {
       Student student = studentRepository.findById(studentId).get();
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectRequestDto, subject);
        subject.setStudent(student);
        subjectRepository.save(subject);
        return "subject create successfully";
    }

    @Override
    public List<Subject> fetchAllStudentSubject(Long studentId) {
       List <Subject> subjects = subjectRepository.findSubjectByStudentId(studentId);

        return subjects;
    }


}
