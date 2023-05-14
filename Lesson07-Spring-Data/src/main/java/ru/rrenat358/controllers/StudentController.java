package ru.rrenat358.controllers;

import ru.rrenat358.entities.Student;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.repositories.StudentRepository;
import ru.rrenat358.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id));
    }

    @GetMapping("/students/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/students/change_score")
    public void changeScore(@RequestParam Long studentId, @RequestParam Integer delta) {
        studentService.changeScore(studentId, delta);
    }


    // Фильтр
    @GetMapping("/students/score_between")
    public List<Student> findStudentsByScoreBetween(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "100") Integer max) {
        return studentService.findByScoreBetween(min, max);
    }
}
