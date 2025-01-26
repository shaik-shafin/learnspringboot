package com.shaik.acknowledge.hibernatemappings.manytoone.service;

import com.shaik.acknowledge.hibernatemappings.manytoone.domain.Project;
import com.shaik.acknowledge.hibernatemappings.manytoone.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    public void saveProject(Project project) {

        projectRepository.save(project);
    }

    public Project getProject(Integer projectId) {

        return projectRepository.findById(projectId).get();
    }

    public void deleteProject(Integer projectId) {

        projectRepository.deleteById(projectId);
    }
}
