package dev.aws.awesomebuilder.controllers;

import dev.aws.awesomebuilder.entities.Employee;
import dev.aws.awesomebuilder.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class WebController {
    @GetMapping("/")
    public String indexAction(){
        return "index";
    }

    @GetMapping("/listEmployees")
    public String listEmployees(Model model){
        model.addAttribute("employees",employeeRepository.findAll());
        return "listEmployees";

    }
    @GetMapping("/addEmployee")
    public String addEmployeeAction(Employee employee){
        return "addEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Employee user = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        employeeRepository.delete(user);
        return "redirect:/listEmployees";
    }

    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("/addEmployeeSubmit")
    public String addEmployeeSubmit(@Valid Employee employee, BindingResult result, Model model){
        if(!result.hasErrors()){
            employeeRepository.save(employee);
            return("redirect:/");
        }else{
            return "addEmployee";
        }

    }
    @GetMapping("/addEmployeeSubmit")
    public String placeholder(){
        return "addEmployee";
    }

}
