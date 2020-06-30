package com.datavenceapi.controllers;

import com.datavenceapi.models.Project;
import com.datavenceapi.repositories.ProjectRepository;
import com.datavenceapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectRepository projectRepository;
    private UserRepository userRepository;
    @Autowired
    public ProjectController(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/projects")
    public List<Project> index() {
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> save(@RequestBody Project project) {
        projectRepository.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @PostMapping("/projects/{id}/add-users")
    public ResponseEntity<Project> addUsersToProject(@PathVariable Long id,
                                  @RequestBody AddUserToProjectDTO addUserToProjectDTO) {
        var project = projectRepository.findById(id);

        if (project.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        for (long userId : addUserToProjectDTO.getUserIds()) {
            var user = userRepository.findById(userId);
            if(user.isPresent()) {
                project.get().addUser(user.get());
            }
        }

        projectRepository.save(project.get());
        return ResponseEntity.ok(project.get());
    }
}
