package com.furama.controller;

import com.furama.model.Division;
import com.furama.model.EducationDegree;
import com.furama.model.Employee;
import com.furama.model.Position;
import com.furama.service.IDivisionService;
import com.furama.service.IEducationDegreeService;
import com.furama.service.IEmployeeService;
import com.furama.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IPositionService positionService;

    @ModelAttribute("divisionList")
    public List<Division> getDivisionList() {
        return divisionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> getEDList() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("positionList")
    public List<Position> getPList() {
        return positionService.findAll();
    }

    @GetMapping("/employee")
    public String goList(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeEdit", new Employee());
        return "employee/listEmployee";
    }

    @GetMapping("/createEmployee")
    public String formCreate(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/listEmployee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/updateEmployee")
    public String showUpdate(@RequestParam Integer id, Model model) {
        model.addAttribute("employeeEdit", employeeService.findById(id));
        System.out.println("here");
        return "employee/listEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/deleteEmployee")
    public String delete(@RequestParam Integer id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }
}
