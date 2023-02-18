package com.marko.mongodb;

import com.marko.mongodb.dtos.AddStudentDTO;
import com.marko.mongodb.dtos.UpdateStudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


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

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") String id) {
        studentService.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable("id") String id, @RequestBody UpdateStudentDTO updateStudentDTO) {
        studentService.updateAStudent(id,updateStudentDTO);

    }
}
