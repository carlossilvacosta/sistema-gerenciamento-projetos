package com.unicap.sistema_gerenciamento_projetos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicap.sistema_gerenciamento_projetos.model.ProjectMember;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
    List<ProjectMember> findByProjectId(Long projectId);

    List<ProjectMember> findByUserId(Long userId);
}
