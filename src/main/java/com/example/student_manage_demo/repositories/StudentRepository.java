package com.example.student_manage_demo.repositories;

import com.example.student_manage_demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
