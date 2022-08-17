package com.medicalDeclaration.controller;

import com.medicalDeclaration.model.MedicalDeclaration;
import com.medicalDeclaration.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping("/")
    public String goList(Model model) {
        List<MedicalDeclaration> medicalDeclarationList = medicalDeclarationService.findAll();
        model.addAttribute("medicalDeclarationList", medicalDeclarationList);
        return "list";
    }

    @GetMapping("/list")
    public String goMedical(Model model) {
        List<String> dayList = medicalDeclarationService.getDayAll();
        model.addAttribute("dayList", dayList);
        List<String> monthList = medicalDeclarationService.getMonthAll();
        model.addAttribute("monthList", monthList);
        List<String> yearList = medicalDeclarationService.getYearAll();
        model.addAttribute("yearList", yearList);
        List<String> genderList = medicalDeclarationService.getGenderAll();
        model.addAttribute("genderList", genderList);
        List<String> nationList = medicalDeclarationService.getNationAll();
        model.addAttribute("nationList", nationList);
        List<String> travelInformationList = medicalDeclarationService.getTravelInformationAll();
        model.addAttribute("travelInformationList", travelInformationList);
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        return "create";
    }

    @PostMapping("/list")
    public String medical(@ModelAttribute MedicalDeclaration medicalDeclaration, Model model) {
        List<MedicalDeclaration> medicalDeclarationList = medicalDeclarationService.create(medicalDeclaration);
        model.addAttribute("medicalDeclarationList", medicalDeclarationList);
        return "list";
    }

    @GetMapping("/update/{idCard}")
    public String goUpdate(@PathVariable String idCard, Model model) {
        MedicalDeclaration medicalDeclaration = medicalDeclarationService.findByIdCard(idCard);
        System.out.println(medicalDeclaration);
        List<String> dayList = medicalDeclarationService.getDayAll();
        model.addAttribute("dayList", dayList);
        List<String> monthList = medicalDeclarationService.getMonthAll();
        model.addAttribute("monthList", monthList);
        List<String> yearList = medicalDeclarationService.getYearAll();
        model.addAttribute("yearList", yearList);
        List<String> genderList = medicalDeclarationService.getGenderAll();
        model.addAttribute("genderList", genderList);
        List<String> nationList = medicalDeclarationService.getNationAll();
        model.addAttribute("nationList", nationList);
        List<String> travelInformationList = medicalDeclarationService.getTravelInformationAll();
        model.addAttribute("travelInformationList", travelInformationList);
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MedicalDeclaration medicalDeclaration) {
        medicalDeclarationService.update(medicalDeclaration);
        return "redirect:/list";
    }

}
