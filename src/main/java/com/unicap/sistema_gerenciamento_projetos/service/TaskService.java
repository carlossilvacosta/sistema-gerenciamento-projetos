package com.unicap.sistema_gerenciamento_projetos.service;

import com.unicap.sistema_gerenciamento_projetos.dtos.TaskCreateDTO;
import com.unicap.sistema_gerenciamento_projetos.dtos.TaskDTO;
import com.unicap.sistema_gerenciamento_projetos.model.Tag;
import com.unicap.sistema_gerenciamento_projetos.model.Task;
import com.unicap.sistema_gerenciamento_projetos.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Autowired
//    private TagRepository tagRepository;

    public TaskDTO createTask(TaskCreateDTO taskCreateDTO) {
        Task task = new Task();
        task.setTitle(taskCreateDTO.getTitle());
        task.setDescription(taskCreateDTO.getDescription());
        task.setCompleted(taskCreateDTO.isCompleted());

//        if (taskCreateDTO.getProjectId() != null) {
//            Project project = projectRepository.findById(taskCreateDTO.getProjectId())
//                    .orElseThrow(() -> new RuntimeException("Project not found"));
//            task.setProject(project);
//        }
//        if (taskCreateDTO.getTagIds() != null && !taskCreateDTO.getTagIds().isEmpty()) {
//            List<Tag> tags = tagRepository.findAllById(taskCreateDTO.getTagIds());
//            task.setTags(tags);
//        }

        task = taskRepository.save(task);
        return convertToDTO(task);
    }

    public TaskDTO updateTask(Long id, TaskCreateDTO taskCreateDTO) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskCreateDTO.getTitle());
        task.setDescription(taskCreateDTO.getDescription());
        task.setCompleted(taskCreateDTO.isCompleted());

//        if (taskCreateDTO.getProjectId() != null) {
//            Project project = projectRepository.findById(taskCreateDTO.getProjectId())
//                    .orElseThrow(() -> new RuntimeException("Project not found"));
//            task.setProject(project);
//        }
//
//        if (taskCreateDTO.getTagIds() != null && !taskCreateDTO.getTagIds().isEmpty()) {
//            List<Tag> tags = tagRepository.findAllById(taskCreateDTO.getTagIds());
//            task.setTags(tags);
//        }

        task = taskRepository.save(task);
        return convertToDTO(task);
    }

    public TaskDTO getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return convertToDTO(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<TaskDTO> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<TaskDTO> getTasksByCompletionStatus(boolean completed) {
        return taskRepository.findByCompleted(completed).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TaskDTO convertToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setCompleted(task.isCompleted());

        if (task.getProject() != null) {
            taskDTO.setProjectId(task.getProject().getId());
        }

        if (task.getTags() != null) {
            taskDTO.setTagIds(task.getTags().stream().map(Tag::getId).collect(Collectors.toList()));
        }

        return taskDTO;
    }
}
