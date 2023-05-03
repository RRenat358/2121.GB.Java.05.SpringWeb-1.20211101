package ru.rrenat358.services;

import ru.rrenat358.entities.Student;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.repositories.StudentRepository;
import ru.rrenat358.repositories.specifications.StudentsSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> find(Integer minScore, Integer maxScore, String partName, Integer page) {
        Specification<Student> spec = Specification.where(null);
        if (minScore != null) {
            spec = spec.and(StudentsSpecifications.scoreGreaterOrEqualsThan(minScore));
        }
        if (maxScore != null) {
            spec = spec.and(StudentsSpecifications.scoreLessThanOrEqualsThan(maxScore));
        }
        if (partName != null) {
            spec = spec.and(StudentsSpecifications.nameLike(partName));
        }

        return studentRepository.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void changeScore(Long studentId, Integer delta) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Unable to change student's score. Student not found, id: " + studentId));
        student.setScore(student.getScore() + delta);
    }

    public List<Student> findByScoreBetween(Integer min, Integer max) {
        return studentRepository.findAllByScoreBetween(min, max);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
