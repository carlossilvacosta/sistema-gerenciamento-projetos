package com.unicap.sistema_gerenciamento_projetos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicap.sistema_gerenciamento_projetos.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTaskId(Long taskId);
}
