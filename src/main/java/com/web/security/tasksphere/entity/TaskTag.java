package com.web.security.tasksphere.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "task_tags", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"task_id", "tag_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}