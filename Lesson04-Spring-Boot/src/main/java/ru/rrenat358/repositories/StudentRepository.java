package ru.rrenat358.repositories;

import org.springframework.stereotype.Component;
import ru.rrenat358.data.Student;

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
                new Student(1L, "Name01"),
                new Student(2L, "Name02"),
                new Student(3L, "Name03")
        ));
    }

    public void add(Student student) {
        students.add(student);
    }



    public List<Student> getAllStudents() {

        return Collections.unmodifiableList(students);
    }

    public Student findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(" -= Student not found =- "));
    }
}
