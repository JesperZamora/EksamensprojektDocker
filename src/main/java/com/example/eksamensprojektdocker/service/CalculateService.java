package com.example.eksamensprojektdocker.service;

import com.example.eksamensprojektdocker.repository.CalculateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateService {
    private CalculateRepository repository;

    public CalculateService(CalculateRepository repository){
        this.repository = repository;
    }

    public List<String> getUsers(){
        return repository.getUsers();
    }
}
