package com.exo1.exo1.service;


import com.exo1.exo1.entity.TaskCountPerProject;
import com.exo1.exo1.repository.TaskCountPerProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskCountService {

    private final TaskCountPerProjectRepository taskCountPerProjectRepository;

    public List<TaskCountPerProject> getTaskCountPerProject() {
        return taskCountPerProjectRepository.findAll();
    }
}