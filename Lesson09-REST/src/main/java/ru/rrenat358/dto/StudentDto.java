package ru.rrenat358.dto;

import com.geekbrains.spring.web.entities.Student;

public class StudentDto {
    private Long id;
    private String name;
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public StudentDto(Student student) {
        this.name = student.getName();
        this.id = student.getId();
        this.score = student.getScore();
    }

    public StudentDto() {
    }
}
