package com.furama.controller;

import com.furama.dto.FacilityDto;
import com.furama.model.Facility;
import com.furama.model.FacilityType;
import com.furama.model.RentType;
import com.furama.service.IFacilityService;
import com.furama.service.IFacilityTypeService;
import com.furama.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/facility")
    public String goListFacility(Model model,
                                 @PageableDefault(5) Pageable pageable,
                                 Optional<String> key) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyWord = key.orElse("");
        Page<Facility> facilityPage = facilityService.findByName(pageable, keyWord);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("keyWord", keyWord);
        return "facility/listFacility";
    }


    @GetMapping("/createFacility")
    public String showCreateFacility(Model model) {
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/createFacility";
    }

    @PostMapping("/createFacility")
    public String createFacility(@ModelAttribute
                                 @Valid FacilityDto facilityDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            List<FacilityType> facilityTypeList = facilityTypeService.findAll();
            List<RentType> rentTypeList = rentTypeService.findAll();
            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "facility/createFacility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        model.addAttribute("facilityDto", facilityDto);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/facility";
    }

    @GetMapping("/updateFacility")
    public String showUpdateFacility(@RequestParam Integer id, Model model) {
        model.addAttribute("facilityDto", facilityService.findById(id));
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "facility/updateFacility";
    }

    @PostMapping("/updateFacility")
    public String updateFacility(@ModelAttribute
                                 @Valid FacilityDto facilityDto,
                                 BindingResult bindingResult,
                                 Facility facility,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            List<FacilityType> facilityTypeList = facilityTypeService.findAll();
            List<RentType> rentTypeList = rentTypeService.findAll();
            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "facility/updateFacility";
        }
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("msg1", "Update successfully!");
        return "redirect:/facility";
    }

    @GetMapping("/deleteFacility")
    public String deleteFacility(@RequestParam Integer id) {
        facilityService.delete(id);
        return "redirect:/facility";
    }

}
