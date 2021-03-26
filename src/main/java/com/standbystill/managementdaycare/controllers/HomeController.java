package com.standbystill.managementdaycare.controllers;

import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.services.FamilyCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    FamilyCRUDService familyCRUDService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/families")
    public String showFamilies(Model model) {
        List<Family> familyList = familyCRUDService.fetchAll();
        model.addAttribute("families", familyList);
        return "families";
    }

}
