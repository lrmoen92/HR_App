package com.astontech.hr.services;

import com.astontech.hr.domain.Project;

public interface ProjectService {

    Project save(Project object);

    Iterable<Project> save(Iterable<Project> objectIterable);

    Project findOne(Integer id);

    boolean exists(Integer id);

    Iterable<Project> findAll();

    long count();

    void delete(Integer id);

    void delete(Project object);

    void delete(Iterable<Project> objectIterable);

    void deleteAll();
}