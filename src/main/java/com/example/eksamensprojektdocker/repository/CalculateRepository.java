package com.example.eksamensprojektdocker.repository;

import com.example.eksamensprojektdocker.model.Project;
import com.example.eksamensprojektdocker.model.Subproject;
import com.example.eksamensprojektdocker.model.Task;
import com.example.eksamensprojektdocker.repository.util.DB_Connector;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculateRepository implements ICalculate {

    public void createProject(Project project){
        try {
            Connection conn = DB_Connector.getConnection();
            String SQL = "INSERT INTO projects (name, startDate, endDate) VALUES (?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, project.getName());
            pstmt.setDate(2, Date.valueOf(project.getStartDate()));
            pstmt.setDate(3, Date.valueOf(project.getEndDate()));
            pstmt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void createSubproject(Subproject subproject){
        try {
            Connection conn = DB_Connector.getConnection();
            String SQL = "INSERT INTO subprojects (name, startDate, endDate) VALUES (?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, subproject.getName());
            pstmt.setDate(2, Date.valueOf(subproject.getStartDate()));
            pstmt.setDate(3, Date.valueOf(subproject.getEndDate()));
            pstmt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void createTask(Task task){
        try {
            Connection conn = DB_Connector.getConnection();
            String SQL = "INSERT INTO tasks (name, startDate, endDate) VALUES (?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, task.getName());
            pstmt.setDate(2, Date.valueOf(task.getStartDate()));
            pstmt.setDate(3, Date.valueOf(task.getEndDate()));
            pstmt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Project> getProjects(){
        List<Project> projectslist = new ArrayList<>();

        try {
            Connection conn = DB_Connector.getConnection();
            String SQL = "SELECT * FROM projects";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                String name = rs.getString(1);
                LocalDate startDate = rs.getDate(2).toLocalDate();
                LocalDate endDate = rs.getDate(3).toLocalDate();

                projectslist.add(new Project(name, startDate, endDate));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return projectslist;
    }

    public Subproject getSubprojects(){
        return null;
    }

    public Task getTask(){
        return null;
    }

/*
    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        try {
            Connection conn = DB_Connector.getConnection();
            String SQL = "SELECT * FROM users;";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                users.add(rs.getString("user_name"));
            }
            stmt.close();

            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }*/

}