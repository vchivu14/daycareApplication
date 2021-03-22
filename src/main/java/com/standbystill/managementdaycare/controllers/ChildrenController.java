package com.standbystill.managementdaycare.controllers;

import com.standbystill.managementdaycare.entities.Children;
import com.standbystill.managementdaycare.services.ChildrenCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChildrenController {
    @Autowired
    ChildrenCRUDService childrenCRUDService;

    @GetMapping("/families/{idF}/children/{idC}")
    public String showChildrenForFamily(@PathVariable("idF") int idF, @PathVariable("idC") int idC, Model model) {
        model.addAttribute("familyId", idF);
        model.addAttribute("childId", idC);
        model.addAttribute("child", childrenCRUDService.findChildById(idC,idF));
        return "child";
    }

    @GetMapping("/families/{idF}/children/{idC}/delete")
    public String deleteChild(@PathVariable("idF") int idF, @PathVariable("idC") int idC) {
        Boolean delete = childrenCRUDService.deleteChild(idC);
        if (delete) {
            return "redirect:/families/"+idF;
        } else {
            return "/error";
        }
    }

    @GetMapping("/families/{id}/children/add")
    public String retrieveChildModel(@PathVariable("id") int id, Model model) {
        model.addAttribute("child", new Children());
        model.addAttribute("familyId", id);
        return "childrenForm";
    }

    @PostMapping("/families/{id}/children/add")
    public String addChild(@PathVariable("id") int id, @ModelAttribute Children child, Model model) {
        int childId = childrenCRUDService.addChild(child, id);
        model.addAttribute("familyId", id);
        model.addAttribute("childId", childId);
        model.addAttribute("child", child);
        return "redirect:/families/"+id;
    }

}
