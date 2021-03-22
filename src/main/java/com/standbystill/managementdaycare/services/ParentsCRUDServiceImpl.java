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
    public int addParent(Parent parent, int familyId) {
        return parentsRepo.addParent(parent, familyId);
    }

    @Override
    public boolean updateParent(String lastName, String firstName, int cpr, int id) {
        return parentsRepo.updateParent(lastName,firstName,cpr,id);
    }

    @Override
    public boolean deleteParent(int parentId) {
        return parentsRepo.deleteParent(parentId);
    }

    @Override
    public Parent findParentById(int parentId) {
        return parentsRepo.findParentById(parentId);
    }

    @Override
    public List<Parent> findParentsByLastName(String name) {
        return parentsRepo.findParentsByLastName(name);
    }
}
