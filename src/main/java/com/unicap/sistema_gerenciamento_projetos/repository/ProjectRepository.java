package com.unicap.sistema_gerenciamento_projetos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicap.sistema_gerenciamento_projetos.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUserId(Long userId);
}
