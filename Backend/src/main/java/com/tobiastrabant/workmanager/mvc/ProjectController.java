package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/list")
    public String showProjectsList() {
        return "projects-list";
    }

    @GetMapping("/add")
    public String showProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "project-form";
    }

    @PostMapping("/addOrUpdate")
    public String processProjectForm(@ModelAttribute Project project,
                                     Model model) {
        model.addAttribute("project", project);
        return "project-confirmation";
    }
}
