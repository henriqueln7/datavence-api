package com.datavenceapi.services;

import com.datavenceapi.models.Project;
import com.datavenceapi.repositories.ProjectRepository;
import com.datavenceapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private UserRepository userRepository;
    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public Project addUserToProject(long projectId, long[] userIds) {
        var project = projectRepository.findById(projectId);

        if (project.isEmpty()) {
            throw new EntityNotFoundException();
        }

        for (long userId : userIds) {
            var user = userRepository.findById(userId);
            if(user.isPresent()) {
                project.get().addUser(user.get());
            }
        }
        return projectRepository.save(project.get());
    }
}
