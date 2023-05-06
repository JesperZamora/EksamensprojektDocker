package com.example.eksamensprojektdocker.controller;

import com.example.eksamensprojektdocker.model.Project;
import com.example.eksamensprojektdocker.model.Subproject;
import com.example.eksamensprojektdocker.model.Task;
import com.example.eksamensprojektdocker.service.CalculateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculateController {
    private CalculateService service;

    public CalculateController(CalculateService service){
        this.service = service;
    }

    //Starting page - direct to loginController
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //Overview of projects (name, start- and end date)
    // createProject() / deleteProject()
    @GetMapping("/projects")
    public String projectPage(){
        //Code
        return "projectPage";
    }

    //Overview of subprojects (name, start- and end date) and tasks (name, start- and end date)
    //createSubproject / deleteSubproject
    @GetMapping("/projects/mainPage")
    public String mainPage(@RequestParam int projectID){
        //Code
        return "mainPage";
    }


    /* ------------------------------------ Create project ----------------------------------------- */
    @GetMapping("/projects/mainPage/createProject")
    public String createProject(Model model){
        //Code
        return "createProject";
    }

    @PostMapping("/projects/mainPage/createProject")
    public String addProject(@ModelAttribute Project project){
        //Code
        return "redirect:/projectPage";
    }


    /* ------------------------------------ Create Subproject -------------------------------------- */
    @GetMapping("/projects/mainPage/createSubproject")
    public String createSubproject(Model model){
        //Code
        return "createSubproject";
    }

    @GetMapping("/projects/mainPage/createSubproject")
    public String addSubproject(@ModelAttribute Subproject subproject){
        //Code
        return "redirect:/projects/mainPage"; // add + project id to make it return to correct project mainPage
    }


    /* ------------------------------------- Create Task ------------------------------------------- */
    @GetMapping("/projects/mainPage/createTask")
    public String createTask(Model model){
        //Code
        return "createTask";
    }

    @PostMapping("/projects/mainPage/createTask")
    public String addTask(@ModelAttribute Task task){
        //Code
        return "redirect:/projects/mainPage"; // add + project id to make it return to correct project mainPage
    }


    /* ------------------------------------- Update Project ----------------------------------------- */
    @GetMapping("/projects/mainPage/updateProject")
    public String updateProject(Model model){
        //Code
        return "";
    }

    @PostMapping("/projects/mainPage/updateProject")
    public String addUpdatedProject(@ModelAttribute Project project){
        //Code
        return "redirect:/projects";
    }

    /* ------------------------------------- Update Subproject -------------------------------------- */

    @GetMapping("/projects/mainPage/updateProject")
    public String updateSubproject(Model model){
        //Code
        return "";
    }

    @PostMapping("/projects/mainPage/updateProject")
    public String addUpdatedSubproject(@ModelAttribute Project project){
        //Code
        return "redirect:/projects/mainPage"; // add + project id to make it return to correct project mainPage
    }


    /* ------------------------------------- Update Task -------------------------------------------- */

    @GetMapping("/projects/mainPage/updateProject")
    public String updateTask(Model model){
        //Code
        return "";
    }

    @PostMapping("/projects/mainPage/updateProject")
    public String addUpdateTask(@ModelAttribute Project project){
        //Code
        return "redirect:/projects/mainPage"; // add + project id to make it return to correct project mainPage
    }


    /* ------------------------------------- Delete Project ----------------------------------------- */

    //Add another methode that directs to a warning page where user can choose to delete or go back

    @GetMapping("/projects/mainPage/delete")
    public String deleteProject(@RequestParam int projectID){
        //code
        return "redirect:/projects";
    }


    /* ------------------------------------- Delete Subproject -------------------------------------- */

    //Add another methode that directs to a warning page where user can choose to delete or go back

    @GetMapping("/projects/mainPage/delete")
    public String deleteSubproject(@RequestParam int subprojectID){
        //code
        return "redirect:/projects/mainPage"; // add + projectID
    }


    /* ------------------------------------- Delete Task -------------------------------------------- */

    //Add another methode that directs to a warning page where user can choose to delete or go back

    @GetMapping("/projects/mainPage/delete")
    public String deleteTask(@RequestParam int taskID){
        //code
        return "redirect:/projects/mainPage"; // add + projectID
    }


/*    @GetMapping("/")
    public String getUsers(Model model){
        List<String> userList = service.getUsers();
        model.addAttribute("userList",userList);
        return "index";
    }*/

}
