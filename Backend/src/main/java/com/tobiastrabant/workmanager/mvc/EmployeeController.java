package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Employee;
import com.tobiastrabant.workmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String showEmployeesList(Model model){
        //TODO add employees from database to the model with identifier "employees"
        List<Employee> employees = employeeService.findAllByOrderByLastNameAsc();
/*        Employee tobias = new Employee();
        tobias.setFirstName("Tobias");
        tobias.setLastName("Trabant");
        tobias.setEmail("trabant@web.de");
        employees.add(tobias);*/
        model.addAttribute("employees",employees);
        return "employees-list";
    }

    @GetMapping("/form")
    public String showEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/form")
    public String processEmployeeForm(@Valid @ModelAttribute("employee") Employee employee,
                                      BindingResult bindingResult,
                                      Model model) {
        model.addAttribute("employee", employee);
        if(bindingResult.hasErrors()) {
            return "employee-form";
        }
        else {
            employeeService.save(employee);
            return "redirect:/employees/list";
        }
    }
}
