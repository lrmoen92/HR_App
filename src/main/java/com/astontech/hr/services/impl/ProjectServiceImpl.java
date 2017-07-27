package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Project;
import com.astontech.hr.repositories.ProjectRepository;
import com.astontech.hr.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project save(Project object) {
        return projectRepository.save(object);
    }

    @Override
    public Iterable<Project> save(Iterable<Project> objectIterable) {
        return projectRepository.save(objectIterable);
    }

    @Override
    public Project findOne(Integer id) {
        return projectRepository.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        return projectRepository.exists(id);
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public long count() {
        return projectRepository.count();
    }

    @Override
    public void delete(Integer id) {
        projectRepository.delete(id);
    }

    @Override
    public void delete(Project object) {
        projectRepository.delete(object);
    }

    @Override
    public void delete(Iterable<Project> objectIterable) {
        projectRepository.delete(objectIterable);
    }

    @Override
    public void deleteAll() {
        projectRepository.deleteAll();
    }
}
