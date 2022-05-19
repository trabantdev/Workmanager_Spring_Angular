package com.tobiastrabant.workmanager.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @RequestMapping("/employees")
    public String showEmployeesList(){
        return "employees-list";
    }

    @RequestMapping("/employee-form")
    public String showEmployeeForm(){
        return "employee-form";
    }

    @RequestMapping("/process-employee-form")
    public String processEmployeeForm(@RequestParam(name="firstName") String firstName,
                                      @RequestParam(name="role") String role,
                                      Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("role", role);
        return "employee-confirmation";
    }
}
