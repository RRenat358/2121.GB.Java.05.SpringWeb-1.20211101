package ru.rrenat358.lifecycle;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alive_beans")
public class AliveBean implements Serializable {
    private static final long serialVersionUID = -2025940487235285735L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

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

    public AliveBean(String name) {
        this.name = name;
    }

    public AliveBean() {
    }

    @Override
    public String toString() {
        return String.format("AliveBean [id = %d, name = %s]", id, name);
    }
}
