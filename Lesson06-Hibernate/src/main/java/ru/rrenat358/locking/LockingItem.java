package ru.rrenat358.locking;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locking_items")
public class LockingItem implements Serializable {
    private static final long serialVersionUID = -1049528515179193867L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private int value;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getVersion() {
        return version;
    }

    public LockingItem() {
    }

    public LockingItem(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("LockingItem [id = %d, value = %d, version = %d]", id, value, version);
    }
}
