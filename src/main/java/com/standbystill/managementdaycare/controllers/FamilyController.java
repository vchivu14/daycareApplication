package com.standbystill.managementdaycare.controllers;

import com.standbystill.managementdaycare.entities.Address;
import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Tenant;
import com.standbystill.managementdaycare.services.AddressCRUDService;
import com.standbystill.managementdaycare.services.FamilyCRUDService;
import com.standbystill.managementdaycare.services.TenantCRUDService;
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
    @Autowired
    TenantCRUDService tenantCRUDService;

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

    @GetMapping("/families/tenant")
    public String retrieveTenantModel(Model model) {
        model.addAttribute("tenant", new Tenant());
        return "tenantForm";
    }

    @PostMapping("/families/tenant")
    public String addTenant(@ModelAttribute Tenant tenant, Model model) {
        int tenantId = tenantCRUDService.addTenant(tenant);
        model.addAttribute("tenantId", tenantId);
        return "resultTenant";
    }

    @GetMapping("/families/tenant/{idT}/address")
    public String retrieveAddressModel(@PathVariable("idT") int idT, Model model) {
        model.addAttribute("tenantId", idT);
        model.addAttribute("address", new Address());
        return "addressForm";
    }

    @PostMapping("/families/tenant/{idT}/address")
    public String addAddress(@PathVariable("idT") int idT, @ModelAttribute Address address, Model model) {
        model.addAttribute("tenantId", idT);
        int addressId = addressCRUDService.addAddress(address, idT);
        model.addAttribute("address", address);
        model.addAttribute("addressId", addressId);
        return "resultAddress";
    }

    @GetMapping("/families/tenant/{idT}/address/{idA}")
    public String retrieveFamilyModel(@PathVariable("idT") int idT, @PathVariable("idA") int idA, Model model) {
        model.addAttribute("tenantId", idT);
        model.addAttribute("addressId", idA);
        model.addAttribute("family", new Family());
        return "familyForm";
    }

    @PostMapping("/families/tenant/{idT}/address/{idA}")
    public String addFamily(@PathVariable("idT") int idT, @PathVariable("idA") int idA, @ModelAttribute Family family, Model model) {
        model.addAttribute("tenantId", idT);
        model.addAttribute("addressId", idA);
        int familyId = familyCRUDService.addFamily(family,idA);
        model.addAttribute("family", family);
        model.addAttribute("familyId", familyId);
        return "redirect:/families/"+familyId;
    }


}
