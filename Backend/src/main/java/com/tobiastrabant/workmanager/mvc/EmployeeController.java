package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Employee;
import com.tobiastrabant.workmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String showEmployeesList(Model model) {
        //TODO add employees from database to the model with identifier "employees"
        List<Employee> employees = employeeService.findAllByOrderByLastNameDesc();
/*        Employee tobias = new Employee();
        tobias.setFirstName("Tobias");
        tobias.setLastName("Trabant");
        tobias.setEmail("trabant@web.de");
        employees.add(tobias);*/
        model.addAttribute("employees", employees);
        return "employees-list";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/add")
    public String processAddEmployeeForm(@Valid @ModelAttribute("employee") Employee employee,
                                         BindingResult bindingResult,
                                         Model model) {
        model.addAttribute("employee", employee);
        if (bindingResult.hasErrors()) {
            return "employee-form";
        } else {
            employeeService.save(employee);
            return "redirect:/employees/list";
        }
    }

    @GetMapping("/update")
    public String showUpdateEmployeeForm(@RequestParam("employeeID") int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee-form";
    }
}
