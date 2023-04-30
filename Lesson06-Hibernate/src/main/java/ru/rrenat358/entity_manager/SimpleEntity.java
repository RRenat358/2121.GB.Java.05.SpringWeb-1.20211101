package ru.rrenat358.entity_manager;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "simple_entities")
public class SimpleEntity {
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

    public SimpleEntity(String name) {
        this.name = name;
    }

    public SimpleEntity() {
    }

    @Override
    public String toString() {
        return String.format("SimpleEntity [id = %d, name = %s]", id, name);
    }
}
