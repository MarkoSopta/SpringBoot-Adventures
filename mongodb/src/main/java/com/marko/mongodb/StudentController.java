package com.marko.mongodb;

import com.marko.mongodb.dtos.AddStudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final StudentRepository studentRepository;

    @GetMapping
    public List<Student> fetchAllStudents() {

        return studentService.getAllStudents();
    }


    @PostMapping
    public void addNewStudent(@RequestBody AddStudentDTO addStudentDTO) {
        studentService.addStudent(addStudentDTO);

    }
}
