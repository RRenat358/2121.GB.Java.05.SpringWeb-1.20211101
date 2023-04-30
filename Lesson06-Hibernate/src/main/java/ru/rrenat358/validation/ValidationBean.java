package ru.rrenat358.validation;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "validation_beans")
public class ValidationBean implements Serializable {
    private static final long serialVersionUID = 5648118653879627076L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Email
    @Column(name = "email")
    @NotNull(groups = {FullRule.class, ShortRule.class})
    private String email;

    @Column(name = "priority")
    @Range(min = 1, max = 10, groups = ShortRule.class)
    private int priority;

    @NotNull
    @Size(min = 6, max = 6, groups = FullRule.class)
    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ValidationBean() {
    }

    @Override
    public String toString() {
        return String.format("ValidationBean [id = %d, email = %s, priority = %d, created_at = %s, updated_at = %s]", id, email, priority, createdAt.toString(), updatedAt.toString());
    }
}
