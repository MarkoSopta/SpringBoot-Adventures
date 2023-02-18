package com.marko.mongodb;

import com.marko.mongodb.dtos.AddStudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }


    public void addStudent(@RequestBody AddStudentDTO addStudentDTO) {

        studentRepository.save(new Student(addStudentDTO.firstname(),
                addStudentDTO.lastname(),
                addStudentDTO.email(),
                addStudentDTO.gender(),
                addStudentDTO.address(),
                addStudentDTO.favSubs(),
                addStudentDTO.totalSpentInBooks(),
                LocalDateTime.now())
        );
    }
}