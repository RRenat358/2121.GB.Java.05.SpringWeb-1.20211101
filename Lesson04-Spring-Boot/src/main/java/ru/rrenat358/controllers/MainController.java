package ru.rrenat358.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rrenat358.data.Student;
import ru.rrenat358.repositories.StudentRepository;

import java.util.List;

@Controller
public class MainController {

    private StudentRepository studentRepository;

    public MainController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
