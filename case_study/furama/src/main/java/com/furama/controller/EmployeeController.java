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
    public String goList(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList",employeeList);
        return "employee/listEmployee";
    }

}
