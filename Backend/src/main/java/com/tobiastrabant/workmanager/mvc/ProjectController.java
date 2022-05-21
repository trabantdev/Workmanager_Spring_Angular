package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Project;
import com.tobiastrabant.workmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/list")
    public String showProjectsList() {
        return "projects-list";
    }

    @GetMapping("/add")
    public String showAddProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "project-form";
    }

    @GetMapping("/update")
    public String showUpdateProjectForm(@RequestParam("projectID") int id, Model model) {
        model.addAttribute("project", projectService.findById(id));
        return "project-form";
    }

    @PostMapping("/addOrUpdate")
    public String processAddEmployeeForm(@Valid @ModelAttribute("project") Project project,
                                         BindingResult bindingResult,
                                         Model model) {
        model.addAttribute("project", project);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "project-form";
        } else {
            projectService.save(project);
            return "redirect:/projects/list";
        }
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam("projectID") int id) {
        projectService.deleteById(id);
        return "redirect:/projects/list";
    }
}
