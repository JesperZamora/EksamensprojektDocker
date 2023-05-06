package com.example.eksamensprojektdocker.service;

import com.example.eksamensprojektdocker.model.Project;
import com.example.eksamensprojektdocker.model.Subproject;
import com.example.eksamensprojektdocker.model.Task;
import com.example.eksamensprojektdocker.repository.ICalculate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateService {
    ICalculate iCalculateRepo;

    public CalculateService(ICalculate iCalculateRepo){
        this.iCalculateRepo = iCalculateRepo;
    }

    public void createProject(Project project){
        iCalculateRepo.createProject(project);
    }

    public void createSubproject(Subproject subproject){
        iCalculateRepo.createSubproject(subproject);
    }

    public void createTask(Task task){
        iCalculateRepo.createTask(task);
    }

    public List<Project> getProjects(){
        return iCalculateRepo.getProjects();
    }



    /*    public List<String> getUsers(){
        return repository.getUsers();
    }*/
}
