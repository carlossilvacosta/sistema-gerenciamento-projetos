package com.unicap.sistema_gerenciamento_projetos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicap.sistema_gerenciamento_projetos.model.ProjectMember;
import com.unicap.sistema_gerenciamento_projetos.repository.ProjectMemberRepository;

@Service
public class ProjectMemberService {
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    public ProjectMember addProjectMember(ProjectMember projectMember) {
        return projectMemberRepository.save(projectMember);
    }

    public ProjectMember getProjectMember(Long id) {
        return projectMemberRepository.findById(id).orElse(null);
    }

    public ProjectMember updateProjectMember(Long id, ProjectMember projectMemberDetails) {
        ProjectMember projectMember = projectMemberRepository.findById(id).orElse(null);
        if (projectMember != null) {
            projectMember.setProject(projectMemberDetails.getProject());
            projectMember.setUser(projectMemberDetails.getUser());
            return projectMemberRepository.save(projectMember);
        }
        return null;
    }

    public void deleteProjectMember(Long id) {
        projectMemberRepository.deleteById(id);
    }

    public List<ProjectMember> getProjectMembersByProjectId(Long projectId) {
        return projectMemberRepository.findByProjectId(projectId);
    }

    public List<ProjectMember> getProjectMembersByUserId(Long userId) {
        return projectMemberRepository.findByUserId(userId);
    }

    public List<ProjectMember> getAllProjectMembers() {
        return projectMemberRepository.findAll();
    }
}
