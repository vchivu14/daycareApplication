package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Children;
import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parents;
import com.standbystill.managementdaycare.repositories.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyCRUDServiceImpl implements FamilyCRUDService {
    @Autowired
    FamilyRepo familyRepo;


    @Override
    public List<Family> fetchAll() {
        return familyRepo.fetchAll();
    }

    @Override
    public int addFamily(Family family) {
        return familyRepo.addFamily(family);
    }

    @Override
    public boolean updateFamily(String name, int familyId) {
        return familyRepo.updateFamily(name, familyId);
    }

    @Override
    public boolean deleteFamily(int familyId) {
        return familyRepo.deleteFamily(familyId);
    }

    @Override
    public Family findFamilyById(int familyId) {
        return familyRepo.findFamilyById(familyId);
    }

    @Override
    public List<Family> findFamilyByName(String name) {
        return familyRepo.findFamilyByName(name);
    }

    @Override
    public List<Parents> findParentsForFamily(int familyId) {
        return familyRepo.findParentsForFamily(familyId);
    }

    @Override
    public List<Children> findChildrenForFamily(int familyId) {
        return familyRepo.findChildrenForFamily(familyId);
    }
}
