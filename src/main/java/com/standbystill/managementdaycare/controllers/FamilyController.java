package com.standbystill.managementdaycare.controllers;

import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.services.FamilyCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FamilyController {
    @Autowired
    FamilyCRUDService familyCRUDService;

    @GetMapping("/families/{id}")
    public String getFamily(@PathVariable("id") int id, Model model) {
        model.addAttribute("familyId", id);
        model.addAttribute("family", familyCRUDService.findFamilyById(id));
        model.addAttribute("parents", familyCRUDService.findParentsForFamily(id));
        model.addAttribute("children", familyCRUDService.findChildrenForFamily(id));
        return "family";
    }

    @GetMapping("/families/{id}/delete")
    public String deleteFamily(@PathVariable("id") int id) {
        Boolean delete = familyCRUDService.deleteFamily(id);
        if (delete) {
            return "redirect:/";
        } else {
            return "error";
        }
    }

    @GetMapping("/families/add")
    public String retrieveFamilyModel(Model model) {
        model.addAttribute("family", new Family());
        return "familyForm";
    }

    @PostMapping("/families/add")
    public String addFamily(@ModelAttribute Family family, Model model) {
        int id = familyCRUDService.addFamily(family);
        model.addAttribute("family", family);
        model.addAttribute("familyId", id);
        return "resultFamily";
    }


}
