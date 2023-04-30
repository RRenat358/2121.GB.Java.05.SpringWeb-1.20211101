package ru.rrenat358.linked_objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bottomless_boxes")
public class BottomlessBox implements Serializable {
    private static final long serialVersionUID = 8430133007206196835L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "box", cascade = CascadeType.ALL)
    private List<Thing> things;

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

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }

    public BottomlessBox() {
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(String.format("Bottomless Box [id = %d, title = %s]:\n", id, title));
        for (Thing t : things) {
            out.append(t.toString()).append("\n");
        }
        return out.toString();
    }
}
