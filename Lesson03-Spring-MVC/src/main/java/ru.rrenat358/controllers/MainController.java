package ru.rrenat358.controllers;

import ru.rrenat358.data.Student;
import ru.rrenat358.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    private StudentRepository studentRepository;

    public MainController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // http://localhost:8189/app

    // GET [http://localhost:8189/app]/add?a=5&b=10
    @GetMapping("/add")
    @ResponseBody
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // GET [http://localhost:8189/app]/product/110/info
    @GetMapping("/product/{id}/info")
    @ResponseBody
    public String showProductInfo(@PathVariable Long id) {
        return "Product #" + id;
    }

    @GetMapping("/students")
    public String showStudentsPage(Model model) {
        model.addAttribute("students", studentRepository.getAllStudents());
        return "students_page";
    }

    @GetMapping("/students/{id}")
    public String showStudentPage(Model model, @PathVariable Long id) {
        Student student = studentRepository.findById(id);
        model.addAttribute("student", student);
        return "student_info_page";
    }
}
