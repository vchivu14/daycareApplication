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
    public int addParent(Parent parent, int familyId, int personId) {
        return parentsRepo.addParent(parent, familyId, personId);
    }
    @Override
    public boolean updateParent(String firstName, String lastName, int age, String email, int phone, int income, int parentId) {
        return parentsRepo.updateParent(firstName,lastName,age,email,phone,income,parentId);
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
