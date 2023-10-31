package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentRepo {

    private List<Student> students = new ArrayList<Student>();

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Optional<Student> getStudentById(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Optional<Student> deleteStudentById(int id) {
        int index = 0;
        for(Student student: students) {
            if(student.getId() == id) {
                return Optional.of(students.remove(index));
            }
            index++;
        }
        return Optional.empty();
    }
}
