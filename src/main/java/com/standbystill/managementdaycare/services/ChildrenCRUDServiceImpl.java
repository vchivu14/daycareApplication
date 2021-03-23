package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Child;
import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.repositories.ChildrenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildrenCRUDServiceImpl implements ChildrenCRUDService {
    @Autowired
    ChildrenRepo childrenRepo;

    @Override
    public List<Child> fetchAll() {
        return childrenRepo.fetchAll();
    }

    @Override
    public List<Child> fetchChildrenForFamily(int familyId) {
        return childrenRepo.fetchChildrenForFamily(familyId);
    }

    @Override
    public Family fetchFamilyForChildren(int familyId) {
        return childrenRepo.fetchFamilyForChildren(familyId);
    }

    @Override
    public void addChild(Child child, int familyId, int personId) {
        childrenRepo.addChild(child,familyId, personId);
    }

    @Override
    public boolean updateChild(String firstName, String lastName, int age, int childId) {
        return childrenRepo.updateChild(firstName,lastName,age,childId);
    }

    @Override
    public boolean deleteChild(int personId) {
        return childrenRepo.deleteChild(personId);
    }

    @Override
    public Child findChildById(int personId) {
        return childrenRepo.findChildById(personId);
    }

    @Override
    public List<Child> findChildrenByLastName(String lastName) {
        return childrenRepo.findChildrenByLastName(lastName);
    }
}
