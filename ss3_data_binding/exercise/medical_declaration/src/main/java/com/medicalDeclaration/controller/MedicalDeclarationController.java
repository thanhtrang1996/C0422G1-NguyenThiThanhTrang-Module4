package com.medicalDeclaration.controller;

import com.medicalDeclaration.model.MedicalDeclaration;
import com.medicalDeclaration.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;
    @GetMapping("/medical")
    public String goMedical(Model model){
        List<String> dayList = medicalDeclarationService.getDayAll();
        model.addAttribute("dayList ", dayList );
        List<String> monthList = medicalDeclarationService.getMonthAll();
        model.addAttribute("monthList ", monthList );
        List<String> yearList = medicalDeclarationService.getYearAll();
        model.addAttribute("yearList ", yearList );
        List<String> genderList = medicalDeclarationService.getGenderAll();
        model.addAttribute("genderList",genderList );
        List<String> nationList = medicalDeclarationService.getNationAll();
        model.addAttribute("nationList ",nationList  );
        model.addAttribute("medicalDeclaration",new MedicalDeclaration());
        return "medical";
    }
    @GetMapping("/medical")
    public  String medical(@ModelAttribute MedicalDeclaration medicalDeclaration,Model model){
        List<MedicalDeclaration> medicalDeclarationList =  medicalDeclarationService.getMedicalAll(medicalDeclaration);
        model.addAttribute("medicalDeclarationList",medicalDeclarationList);
        return "result";
    }
}
