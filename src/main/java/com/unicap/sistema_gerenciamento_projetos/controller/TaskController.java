package com.unicap.sistema_gerenciamento_projetos.controller;

import com.unicap.sistema_gerenciamento_projetos.dtos.TaskCreateDTO;
import com.unicap.sistema_gerenciamento_projetos.dtos.TaskDTO;
import com.unicap.sistema_gerenciamento_projetos.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskCreateDTO taskCreateDTO) {
        TaskDTO taskDTO = taskService.createTask(taskCreateDTO);
        return ResponseEntity.ok(taskDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskCreateDTO taskCreateDTO) {
        TaskDTO taskDTO = taskService.updateTask(id, taskCreateDTO);
        return ResponseEntity.ok(taskDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id) {
        TaskDTO taskDTO = taskService.getTask(id);
        return ResponseEntity.ok(taskDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<TaskDTO>> getTasksByProject(@PathVariable Long projectId) {
        List<TaskDTO> tasks = taskService.getTasksByProject(projectId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/status/{completed}")
    public ResponseEntity<List<TaskDTO>> getTasksByCompletionStatus(@PathVariable boolean completed) {
        List<TaskDTO> tasks = taskService.getTasksByCompletionStatus(completed);
        return ResponseEntity.ok(tasks);
    }
}
