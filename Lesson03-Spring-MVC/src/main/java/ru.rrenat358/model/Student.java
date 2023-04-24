package ru.rrenat358.model;

//@Table(name = "student")
public class Student {

  private Long id;
  private String name;

  public Student(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
