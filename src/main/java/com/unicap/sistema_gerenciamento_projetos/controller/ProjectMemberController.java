package com.unicap.sistema_gerenciamento_projetos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicap.sistema_gerenciamento_projetos.model.ProjectMember;
import com.unicap.sistema_gerenciamento_projetos.service.ProjectMemberService;

@RestController
@RequestMapping("/project-members")
public class ProjectMemberController {
    @Autowired
    private ProjectMemberService projectMemberService;

    @PostMapping
    public ResponseEntity<ProjectMember> addProjectMember(@RequestBody ProjectMember projectMember) {
        return ResponseEntity.ok(projectMemberService.addProjectMember(projectMember));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectMember> getProjectMember(@PathVariable Long id) {
        return ResponseEntity.ok(projectMemberService.getProjectMember(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectMember> updateProjectMember(@PathVariable Long id,
            @RequestBody ProjectMember projectMemberDetails) {
        return ResponseEntity.ok(projectMemberService.updateProjectMember(id, projectMemberDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectMember(@PathVariable Long id) {
        projectMemberService.deleteProjectMember(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ProjectMember>> getProjectMembersByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectMemberService.getProjectMembersByProjectId(projectId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProjectMember>> getProjectMembersByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(projectMemberService.getProjectMembersByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<ProjectMember>> getAllProjectMembers() {
        return ResponseEntity.ok(projectMemberService.getAllProjectMembers());
    }
}
