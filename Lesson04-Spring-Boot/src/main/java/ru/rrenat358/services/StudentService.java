package ru.rrenat358.services;

import ru.rrenat358.data.Student;
import ru.rrenat358.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void changeScore(Long studentId, Integer delta) {
        Student student = studentRepository.findById(studentId);
        student.setScore(student.getScore() + delta);
        // studentRepository.save(student);
    }
}
