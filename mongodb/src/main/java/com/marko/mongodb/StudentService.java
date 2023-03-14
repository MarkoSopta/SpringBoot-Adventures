package com.marko.mongodb;

import com.marko.mongodb.dtos.AddStudentDTO;
import com.marko.mongodb.dtos.UpdateStudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        studentRepository.save(new Student(
                addStudentDTO.firstname(),
                addStudentDTO.lastname(),
                addStudentDTO.email(),
                addStudentDTO.gender(),
                addStudentDTO.address(),
                addStudentDTO.favSubs(),
                addStudentDTO.totalSpentInBooks(),
                LocalDateTime.now())
        );
    }




    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }


    public void updateAStudent(String id, UpdateStudentDTO updateStudentDTO)
    {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstname(updateStudentDTO.firstname());
            student.setLastname(updateStudentDTO.lastname());
            student.setEmail(updateStudentDTO.email());
            student.setGender(updateStudentDTO.gender());
            student.setAddress(updateStudentDTO.address());
            student.setFavSubs(updateStudentDTO.favSubs());
            student.setTotalSpentInBooks(updateStudentDTO.totalSpentInBooks());
            studentRepository.save(student);
        } else {
            System.out.println("Ne postoji");
        }

    }
}

