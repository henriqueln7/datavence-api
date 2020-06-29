package com.datavenceapi.controllers;

import com.datavenceapi.models.Project;
import com.datavenceapi.models.User;
import com.datavenceapi.repositories.ProjectRepository;
import com.datavenceapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/projects")
    public List<Project> index() {
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> save(@RequestBody Project project) {
        projectRepository.save(project);
        return ResponseEntity.ok(project);
    }

}
