package com.standbystill.managementdaycare.controllers;

import com.standbystill.managementdaycare.entities.Parent;
import com.standbystill.managementdaycare.services.ParentsCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParentsController {
    @Autowired
    ParentsCRUDService parentsCRUDService;

    @GetMapping("/families/{idF}/parents/{idP}")
    public String showParentsForFamily(@PathVariable("idF") int idF, @PathVariable("idP") int idP, Model model) {
        model.addAttribute("familyId", idF);
        model.addAttribute("parentId", idP);
        model.addAttribute("parent", parentsCRUDService.findParentById(idP));
        return "parent";
    }

    @GetMapping("/families/{idF}/parents/{idP}/delete")
    public String deleteParent(@PathVariable("idF") int idF, @PathVariable("idP") int idP) {
        Boolean delete = parentsCRUDService.deleteParent(idP);
        if (delete) {
            return "redirect:/families/"+idF;
        } else {
            return "/error";
        }
    }

    @GetMapping("/families/{id}/parents/add")
    public String retrieveParentsModel(@PathVariable("id") int id, Model model) {
        model.addAttribute("parent", new Parent());
        model.addAttribute("familyId", id);
        return "parentsForm";
    }

    @PostMapping("/families/{id}/parents/add")
    public String addParent(@PathVariable("id") int id, @ModelAttribute Parent parent, Model model) {
        int parentId = parentsCRUDService.addParent(parent, id);
        model.addAttribute("parent", parent);
        model.addAttribute("parentId", parentId);
        model.addAttribute("familyId", id);
        return "redirect:/families/"+id;
    }
}
