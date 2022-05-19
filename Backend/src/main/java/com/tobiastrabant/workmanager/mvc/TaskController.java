package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping("/list")
    public String showTasksList() {
        return "tasks-list";
    }

    @GetMapping("/form")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/form")
    public String processTaskForm(@ModelAttribute Task task,
                                  Model model) {
        model.addAttribute("task", task);
        return "task-confirmation";
    }
}
