package com.unicap.sistema_gerenciamento_projetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicap.sistema_gerenciamento_projetos.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
