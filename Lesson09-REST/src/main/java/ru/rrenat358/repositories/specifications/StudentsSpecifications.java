package ru.rrenat358.repositories.specifications;

import ru.rrenat358.entities.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentsSpecifications {
    public static Specification<Student> scoreGreaterOrEqualsThan(Integer score) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("score"), score);
    }

    public static Specification<Student> scoreLessThanOrEqualsThan(Integer score) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("score"), score);
    }

    public static Specification<Student> nameLike(String namePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%", namePart));
    }
}
