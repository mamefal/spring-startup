package com.exo1.exo1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task_count_per_project")
@Getter
@Setter
public class TaskCountPerProject {

    @Id
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "task_count")
    private Long taskCount;
}