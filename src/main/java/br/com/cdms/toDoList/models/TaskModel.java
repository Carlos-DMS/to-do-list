package br.com.cdms.toDoList.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name= "task_table")
public class TaskModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private LocalDate deadline;
    @Column(nullable = false)
    private Boolean status;

    @Transient
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TaskModel() {
    }

    public TaskModel(String name, String description, String deadline) {
        this.name = name;
        this.description = description;
        this.deadline = LocalDate.parse(deadline, dateFormatter);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getDeadlineToString() {
        return deadline.format(dateFormatter);
    }

    public void setDeadline(String deadline) {
        this.deadline = LocalDate.parse(deadline, dateFormatter);
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return Objects.equals(id, taskModel.id) && Objects.equals(name, taskModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
