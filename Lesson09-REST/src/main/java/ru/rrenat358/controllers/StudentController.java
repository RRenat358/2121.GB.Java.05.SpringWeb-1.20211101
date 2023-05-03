package ru.rrenat358.controllers;

import ru.rrenat358.dto.StudentDto;
import ru.rrenat358.entities.Student;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.repositories.StudentRepository;
import ru.rrenat358.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Page<StudentDto> getAllStudents(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_score", required = false) Integer minScore,
            @RequestParam(name = "max_score", required = false) Integer maxScore,
            @RequestParam(name = "name_part", required = false) String namePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return studentService.find(minScore, maxScore, namePart, page).map(
                s -> new StudentDto(s)
        );
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id));
    }

    @PostMapping
    public Student saveNewStudent(@RequestBody Student student) {
        student.setId(null);
        return studentService.save(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
