package com.standbystill.managementdaycare.controllers;

import com.standbystill.managementdaycare.entities.Address;
import com.standbystill.managementdaycare.entities.Child;
import com.standbystill.managementdaycare.entities.Parent;
import com.standbystill.managementdaycare.entities.Person;
import com.standbystill.managementdaycare.services.AddressCRUDService;
import com.standbystill.managementdaycare.services.ChildrenCRUDService;
import com.standbystill.managementdaycare.services.PersonCRUDService;
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
    @Autowired
    PersonCRUDService personCRUDService;
    @Autowired
    AddressCRUDService addressCRUDService;

    @GetMapping("/families/{idF}/child/{idC}")
    public String showChildrenForFamily(@PathVariable("idF") int idF, @PathVariable("idC") int idC, Model model) {
        model.addAttribute("familyId", idF);
        model.addAttribute("childId", idC);
        model.addAttribute("child", childrenCRUDService.findChildById(idC,idF));
        return "child";
    }

    @GetMapping("/families/{idF}/child/{idC}/delete")
    public String deleteChild(@PathVariable("idF") int idF, @PathVariable("idC") int idC) {
        Boolean delete = childrenCRUDService.deleteChild(idC);
        if (delete) {
            return "redirect:/families/"+idF;
        } else {
            return "/error";
        }
    }

    @GetMapping("/families/{idF}/address/child")
    public String retrieveAddressModel(@PathVariable("idF") int idF, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("address", new Address());
        return "formAddressC";
    }

    @PostMapping("/families/{idF}/address/child")
    public String addAddress(@PathVariable("idF") int idF, @ModelAttribute Address address, Model model) {
        model.addAttribute("familyID", idF);
        int addressId = addressCRUDService.addAddress(address);
        model.addAttribute("address", address);
        model.addAttribute("addressId", addressId);
        return "resultAddressC";
    }

    @GetMapping("/families/{idF}/address/{idA}/person/child")
    public String retrievePersonModel(@PathVariable("idF") int idF, @PathVariable("idA") int idA, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("addressId", idA);
        model.addAttribute("person", new Person());
        return "formPersonC";
    }

    @PostMapping("/families/{idF}/address/{idA}/person/child")
    public String addPerson(@PathVariable("idF") int idF, @PathVariable("idA") int idA,
                            @ModelAttribute Person person, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("addressId", idA);
        int personId = personCRUDService.addPerson(person, idA);
        model.addAttribute("person", person);
        model.addAttribute("personId", personId);
        return "resultPersonC";
    }

    @GetMapping("/families/{idF}/address/{idA}/person/{idP}/child")
    public String retrieveChildModel(@PathVariable("idF") int idF, @PathVariable("idA") int idA,
                                      @PathVariable("idP") int idP, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("addressId", idA);
        model.addAttribute("personId", idP);
        model.addAttribute("child", new Child());
        return "formChild";
    }

    @PostMapping("/families/{idF}/address/{idA}/person/{idP}/child")
    public String addChild(@PathVariable("idF") int idF, @PathVariable("idA") int idA, @PathVariable("idP") int idP,
                            @ModelAttribute Child child, Model model) {
        model.addAttribute("familyID", idF);
        model.addAttribute("addressId", idA);
        model.addAttribute("personId", idP);
        model.addAttribute("child", child);
        int childId = childrenCRUDService.addChild(child,idF,idP);
        model.addAttribute("childId", childId);
        return "resultChild";
    }

}
