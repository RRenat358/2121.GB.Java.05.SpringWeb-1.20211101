package ru.rrenat358.one_to_many_and_back;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "universities")
@NamedQueries({
        @NamedQuery(name = "withStudents", query = "SELECT u FROM University u JOIN FETCH u.students WHERE u.id = :id")
})
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "university")
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University() {
    }

    @Override
    public String toString() {
        return String.format("University [id = %d, title = %s, students_count = %d]", id, title, students.size());
    }
}
