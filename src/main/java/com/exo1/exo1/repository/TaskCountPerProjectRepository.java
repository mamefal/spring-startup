package com.exo1.exo1.repository;

import com.exo1.exo1.entity.TaskCountPerProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCountPerProjectRepository extends JpaRepository<TaskCountPerProject, Long> {
}