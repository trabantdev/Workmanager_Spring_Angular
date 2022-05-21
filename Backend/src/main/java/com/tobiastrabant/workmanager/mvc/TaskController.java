package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Task;
import com.tobiastrabant.workmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/list")
    public String showTasksList() {
        return "tasks-list";
    }

    @GetMapping("/add")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @GetMapping("/update")
    public String showUpdateTaskForm(@RequestParam("taskID") int id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        return "task-form";
    }

    @PostMapping("/addOrUpdate")
    public String processAddTaskForm(@Valid @ModelAttribute("task") Task task,
                                         BindingResult bindingResult,
                                         Model model) {
        model.addAttribute("task", task);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "task-form";
        } else {
            taskService.save(task);
            return "redirect:/tasks/list";
        }
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam("taskID") int id) {
        taskService.deleteById(id);
        return "redirect:/tasks/list";
    }
}
