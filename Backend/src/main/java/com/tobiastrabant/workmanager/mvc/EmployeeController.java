package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/list")
    public String showEmployeesList(Model model){
        //TODO add employees to the model with identifier "employees"
        List<Employee> employees = new ArrayList<>();
        Employee tobias = new Employee();
        tobias.setFirstName("Tobias");
        tobias.setLastName("Trabant");
        tobias.setEmail("trabant@web.de");
        employees.add(tobias);
        model.addAttribute("employees",employees);
        return "employees-list";
    }

    @GetMapping("/form")
    public String showEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/form")
    public String processEmployeeForm(@Valid @ModelAttribute Employee employee,
                                      BindingResult bindingResult,
                                      Model model) {
        model.addAttribute("employee", employee);
        if(bindingResult.hasErrors()) {
            return "employee-form";
        }
        else {
            return "employee-confirmation";
        }
    }
}
