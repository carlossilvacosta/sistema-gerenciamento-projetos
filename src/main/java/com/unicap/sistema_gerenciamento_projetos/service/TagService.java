package com.unicap.sistema_gerenciamento_projetos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicap.sistema_gerenciamento_projetos.model.Tag;
import com.unicap.sistema_gerenciamento_projetos.repository.TagRepository;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag getTag(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    public Tag updateTag(Long id, Tag tagDetails) {
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag != null) {
            tag.setName(tagDetails.getName());
            return tagRepository.save(tag);
        }
        return null;
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    public List<Tag> findByName(String name) {
        return tagRepository.findByName(name);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
