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
                new Student(1L, "Name01", 80),
                new Student(2L, "Name02", 80),
                new Student(3L, "Name03", 80)
        ));
    }

    public void add(Student student) {
        students.add(student);
    }



    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }

    public Student findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
