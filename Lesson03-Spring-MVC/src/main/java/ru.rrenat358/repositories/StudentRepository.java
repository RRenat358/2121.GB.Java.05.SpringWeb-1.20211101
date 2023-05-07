package ru.rrenat358.repositories;

import ru.rrenat358.data.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>(List.of(
                new Student(1L, "Bob"),
                new Student(2L, "Michael"),
                new Student(3L, "John")
        ));
        students.removeIf(s -> s.getId().equals(1L));
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    public Student findById(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
