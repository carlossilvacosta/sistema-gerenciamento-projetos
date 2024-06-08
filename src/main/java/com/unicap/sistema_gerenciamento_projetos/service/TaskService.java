package com.unicap.sistema_gerenciamento_projetos.service;

import com.unicap.sistema_gerenciamento_projetos.model.Project;
import com.unicap.sistema_gerenciamento_projetos.model.Tag;
import com.unicap.sistema_gerenciamento_projetos.model.Task;
import com.unicap.sistema_gerenciamento_projetos.repository.ProjectRepository;
import com.unicap.sistema_gerenciamento_projetos.repository.TagRepository;
import com.unicap.sistema_gerenciamento_projetos.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TagRepository tagRepository;

    public Task createTask(Task task, Long projectId, List<Long> tagIds) {
        if (projectId != null) {
            Project project = projectRepository.findById(projectId)
                    .orElseThrow(() -> new RuntimeException("Project not found"));
            task.setProject(project);
        }

        if (tagIds != null && !tagIds.isEmpty()) {
            List<Tag> tags = tagRepository.findAllById(tagIds);
            task.setTags(tags);
        }

        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails, Long projectId, List<Long> tagIds) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());

        if (projectId != null) {
            Project project = projectRepository.findById(projectId)
                    .orElseThrow(() -> new RuntimeException("Project not found"));
            task.setProject(project);
        }

        if (tagIds != null && !tagIds.isEmpty()) {
            List<Tag> tags = tagRepository.findAllById(tagIds);
            task.setTags(tags);
        }

        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public List<Task> getTasksByCompletionStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }
}
