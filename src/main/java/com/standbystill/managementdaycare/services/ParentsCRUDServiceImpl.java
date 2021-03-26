package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parent;
import com.standbystill.managementdaycare.repositories.ParentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentsCRUDServiceImpl implements ParentsCRUDService {
    @Autowired
    ParentsRepo parentsRepo;

    @Override
    public List<Parent> fetchAll() {
        return parentsRepo.fetchAll();
    }

    @Override
    public List<Parent> fetchParentsForFamily(int familyId) {
        return parentsRepo.fetchParentsForFamily(familyId);
    }

    @Override
    public Family fetchFamilyForParent(int familyId) {
        return parentsRepo.fetchFamilyForParent(familyId);
    }

    @Override
    public void addParent(Parent parent, int familyId, int personId) {
        parentsRepo.addParent(parent, familyId, personId);
    }
    @Override
    public boolean updateParent(Parent parent, int personId) {
        return parentsRepo.updateParent(parent, personId);
    }

    @Override
    public boolean deleteParent(int personId) {
        return parentsRepo.deleteParent(personId);
    }

    @Override
    public Parent findParentById(int personId) {
        return parentsRepo.findParentById(personId);
    }

    @Override
    public List<Parent> findParentsByLastName(String name) {
        return parentsRepo.findParentsByLastName(name);
    }
}
