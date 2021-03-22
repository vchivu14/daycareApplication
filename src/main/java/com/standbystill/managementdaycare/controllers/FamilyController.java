package com.standbystill.managementdaycare.controllers;

import com.standbystill.managementdaycare.entities.Address;
import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.services.AddressCRUDService;
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
    @Autowired
    AddressCRUDService addressCRUDService;

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

    @GetMapping("/families/address/{id}/add")
    public String retrieveFamilyModel(@PathVariable("id") int id, Model model) {
        model.addAttribute("addressId", id);
        model.addAttribute("family", new Family());
        return "familyForm";
    }

    @PostMapping("/families/address/{id}/add")
    public String addFamily(@PathVariable("id") int idA, @ModelAttribute Family family, Model model) {
        int id = familyCRUDService.addFamily(family,idA);
        model.addAttribute("family", family);
        model.addAttribute("familyId", id);
        return "resultFamily";
    }

    @GetMapping("/families/address/add")
    public String retrieveAddressModel(Model model) {
        model.addAttribute("address", new Address());
        return "addressForm";
    }

    @PostMapping("/families/address/add")
    public String addAddress(@ModelAttribute Address address, Model model) {
        int id = addressCRUDService.addAddress(address);
        model.addAttribute("address", address);
        model.addAttribute("addressId", id);
        return "resultAddress";

    }


}
