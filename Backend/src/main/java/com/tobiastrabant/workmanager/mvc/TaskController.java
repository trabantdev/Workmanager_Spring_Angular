package com.tobiastrabant.workmanager.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class TaskController {

    @RequestMapping("/tasks")
    public String showTasksList() {
        return "tasks-list";
    }

    @RequestMapping("/task-form")
    public String showTaskForm() {
        return "task-form";
    }

    @RequestMapping("/process-task-form")
    public String processTaskForm(@RequestParam(name="deadline") Date deadline,
                                  @RequestParam(name="name") String name,
                                  @RequestParam(name="description") String description,
                                  @RequestParam(name="priority") String priority,
                                  Model model) {
        return "task-confirmation";
    }
}
