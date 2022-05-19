package com.tobiastrabant.workmanager.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ProjectController {

    @RequestMapping("/projects")
    public String showProjectsList() {
        return "projects-list";
    }

    @RequestMapping("/project-form")
    public String showProjectForm() {
        return "project-form";
    }

    @RequestMapping("/project-confirmation")
    public String processProjectForm(@RequestParam(name="deadline") Date deadline,
                                     @RequestParam(name="name") String name,
                                     @RequestParam(name="description") String description,
                                     @RequestParam(name="priority") String priority,
                                     Model model) {
        return "project-confirmation";
    }
}
