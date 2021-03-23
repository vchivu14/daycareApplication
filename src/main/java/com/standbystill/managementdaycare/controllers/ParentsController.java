package com.standbystill.managementdaycare.controllers;

import com.standbystill.managementdaycare.entities.CPR;
import com.standbystill.managementdaycare.entities.Parent;
import com.standbystill.managementdaycare.entities.Person;
import com.standbystill.managementdaycare.services.CPRCRUDService;
import com.standbystill.managementdaycare.services.ParentsCRUDService;
import com.standbystill.managementdaycare.services.PersonCRUDService;
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
    @Autowired
    CPRCRUDService cprcrudService;
    @Autowired
    PersonCRUDService personCRUDService;

    @GetMapping("/families/{idF}/parent/{idP}")
    public String showParentForFamily(@PathVariable("idF") int idF, @PathVariable("idP") int idP, Model model) {
        model.addAttribute("familyId", idF);
        model.addAttribute("parentId", idP);
        model.addAttribute("parent", parentsCRUDService.findParentById(idP));
        return "parent";
    }

    @GetMapping("/families/{idF}/parent/{idP}/delete")
    public String deleteParent(@PathVariable("idF") int idF, @PathVariable("idP") int idP) {
        Boolean delete = parentsCRUDService.deleteParent(idP);
        if (delete) {
            return "redirect:/families/"+idF;
        } else {
            return "/error";
        }
    }

    @GetMapping("/families/{idF}/person")
    public String retrievePersonModel(@PathVariable("idF") int idF, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/families/{idF}/person")
    public String addPerson(@PathVariable("idF") int idF, @ModelAttribute Person person, Model model) {
        model.addAttribute("familyID", idF);
        int personId = personCRUDService.addPerson(person);
        model.addAttribute("person", person);
        model.addAttribute("personId", personId);
        return "resultPerson";
    }

    @GetMapping("/families/{idF}/person/{idP}/cpr")
    public String retrieveCprModel(@PathVariable("idF") int idF, @PathVariable("idP") int idP, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("personId", idP);
        model.addAttribute("cpr", new CPR());
        return "CPRForm";
    }

    @PostMapping("/families/{idF}/person/{idP}/cpr")
    public String addCpr(@PathVariable("idF") int idF, @PathVariable("idP") int idP,
                         @ModelAttribute CPR cpr, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("personId", idP);
        int cprId = cprcrudService.addCPR(cpr, idP);
        model.addAttribute("cprId", cprId);
        return "resultCPR";
    }

    @GetMapping("/families/{idF}/person/{idP}/cpr/{idC}/parent")
    public String retrieveParentsModel(@PathVariable("idF") int idF, @PathVariable("idP") int idP,
                                       @PathVariable("idC") int idC, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("personId", idP);
        model.addAttribute("cprId", idC);
        model.addAttribute("parent", new Parent());
        return "parentForm";
    }

    @PostMapping("/families/{idF}/person/{idP}/cpr/{idC}/parent")
    public String addParent(@PathVariable("idF") int idF, @PathVariable("idP") int idP,
                            @PathVariable("idC") int idC, @ModelAttribute Parent parent, Model model) {
        model.addAttribute("familyId", idF);
        model.addAttribute("personId", idP);
        model.addAttribute("cprId", idC);
        int parentId = parentsCRUDService.addParent(parent, idF, idC);
        model.addAttribute("parent", parent);
        model.addAttribute("parentId", parentId);
        return "resultParent";
    }
}
