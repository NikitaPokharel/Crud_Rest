package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentRepo.getAllStudents();
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
    studentRepo.addStudent(student);
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable("id") int id)
    {
        return studentRepo.getStudentById(id);
    }
//
    @DeleteMapping("/studentdel/{id}")
    private void deleteStudent(@PathVariable("id") int id)
    {
        studentRepo.deleteStudentById(id);
    }

//    @PostMapping("/student")
//    private int saveStudent(@RequestBody Student student)
//    {
//        studentService.saveOrUpdate(student);
//        return student.getId();
//    }
}
