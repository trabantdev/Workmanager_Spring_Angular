package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/list")
    public String showEmployeesList(){
        return "employees-list";
    }

    @GetMapping("/form")
    public String showEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/form")
    public String processEmployeeForm(@ModelAttribute Employee employee,
                                      Model model) {
        model.addAttribute("employee", employee);
        return "employee-confirmation";
    }
}
