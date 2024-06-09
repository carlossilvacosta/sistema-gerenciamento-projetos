package com.unicap.sistema_gerenciamento_projetos.controller;

import com.unicap.sistema_gerenciamento_projetos.model.Task;
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
    public ResponseEntity<Task> createTask(@RequestBody Task task,
            @RequestParam(required = false) Long projectId,
            @RequestParam(required = false) List<Long> tagIds) {
        Task createdTask = taskService.createTask(task, projectId, tagIds);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,
            @RequestBody Task taskDetails,
            @RequestParam(required = false) Long projectId,
            @RequestParam(required = false) List<Long> tagIds) {
        Task updatedTask = taskService.updateTask(id, taskDetails, projectId, tagIds);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Task>> getTasksByProject(@PathVariable Long projectId) {
        List<Task> tasks = taskService.getTasksByProject(projectId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/status/{completed}")
    public ResponseEntity<List<Task>> getTasksByCompletionStatus(@PathVariable boolean completed) {
        List<Task> tasks = taskService.getTasksByCompletionStatus(completed);
        return ResponseEntity.ok(tasks);
    }
}
