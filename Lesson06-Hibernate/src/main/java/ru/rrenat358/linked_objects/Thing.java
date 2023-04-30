package ru.rrenat358.linked_objects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "things")
public class Thing implements Serializable {
    private static final long serialVersionUID = 8938022199449077919L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "box_id")
    private BottomlessBox box;

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

    public BottomlessBox getBox() {
        return box;
    }

    public void setBox(BottomlessBox box) {
        this.box = box;
    }

    public Thing() {
    }

    @Override
    public String toString() {
        return String.format("Thing [id = %d, title = %s]", id, title);
    }
}
