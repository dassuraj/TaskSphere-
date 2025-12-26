package com.web.security.tasksphere.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "sub_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subtask title is required")
    @Column(length = 150)
    private String title;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    @NotNull(message = "Parent Task is required")
    private Task task;

    @Enumerated(EnumType.STRING)
    private Status status; // TODO, IN_PROGRESS, DONE

    @PrePersist
    public void prePersist() {
        if (status == null) status = Status.TODO;
    }

    public enum Status {
        TODO, IN_PROGRESS, DONE
    }
}
