package com.example.eksamensprojektdocker.repository;

import com.example.eksamensprojektdocker.model.Project;
import com.example.eksamensprojektdocker.model.Subproject;
import com.example.eksamensprojektdocker.model.Task;

import java.util.List;

public interface ICalculate {

    void createProject(Project project);
    void createSubproject(Subproject subproject);
    void createTask(Task task);
    List<Project> getProjects();

}
