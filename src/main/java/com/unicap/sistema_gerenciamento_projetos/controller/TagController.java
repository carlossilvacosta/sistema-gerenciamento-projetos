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

import com.unicap.sistema_gerenciamento_projetos.model.Tag;
import com.unicap.sistema_gerenciamento_projetos.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.createTag(tag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.getTag(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tagDetails) {
        return ResponseEntity.ok(tagService.updateTag(id, tagDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Tag>> getTagsByName(@PathVariable String name) {
        return ResponseEntity.ok(tagService.findByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }
}
