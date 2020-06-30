package com.datavenceapi.controllers;

import com.datavenceapi.models.Project;
import com.datavenceapi.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<Project> index() {
        return projectService.findAll();
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> save(@RequestBody @Valid Project project) {
        projectService.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @PostMapping("/projects/{id}/users")
    public ResponseEntity<Project> addUsersToProject(@PathVariable Long id,
                                                     @RequestBody AddUserToProjectDTO addUserToProjectDTO) {
       var project = projectService.addUserToProject(id, addUserToProjectDTO.getUserIds());
       if(project == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }
}
