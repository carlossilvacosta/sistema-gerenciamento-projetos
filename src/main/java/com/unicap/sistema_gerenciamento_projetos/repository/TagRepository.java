package com.unicap.sistema_gerenciamento_projetos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicap.sistema_gerenciamento_projetos.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByName(String name);
}