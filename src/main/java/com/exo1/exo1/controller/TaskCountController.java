package com.exo1.exo1.controller;


import com.exo1.exo1.entity.TaskCountPerProject;
import com.exo1.exo1.service.TaskCountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task-counts")
@AllArgsConstructor
public class TaskCountController {

    private final TaskCountService taskCountService;

    @GetMapping
    public ResponseEntity<List<TaskCountPerProject>> getTaskCountPerProject() {
        return ResponseEntity.ok(taskCountService.getTaskCountPerProject());
    }
}
