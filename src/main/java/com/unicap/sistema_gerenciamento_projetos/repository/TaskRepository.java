package com.unicap.sistema_gerenciamento_projetos.repository;

import com.unicap.sistema_gerenciamento_projetos.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
    List<Task> findByCompleted(boolean completed);
}
