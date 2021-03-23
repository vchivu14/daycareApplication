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
    public int addChild(Child child, int familyId, int personId) {
        return childrenRepo.addChild(child,familyId, personId);
    }

    @Override
    public boolean updateChild(String firstName, String lastName, int age, int childId) {
        return childrenRepo.updateChild(firstName,lastName,age,childId);
    }

    @Override
    public boolean deleteChild(int id) {
        return childrenRepo.deleteChild(id);
    }

    @Override
    public Child findChildById(int childId, int familyId) {
        return childrenRepo.findChildById(childId,familyId);
    }

    @Override
    public List<Child> findChildrenByLastName(String lastName) {
        return childrenRepo.findChildrenByLastName(lastName);
    }
}
