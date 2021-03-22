package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Children;
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
    public List<Children> fetchAll() {
        return childrenRepo.fetchAll();
    }

    @Override
    public List<Children> fetchChildrenForFamily(int familyId) {
        return childrenRepo.fetchChildrenForFamily(familyId);
    }

    @Override
    public Family fetchFamilyForChildren(int familyId) {
        return childrenRepo.fetchFamilyForChildren(familyId);
    }

    @Override
    public int addChild(Children child, int familyId) {
        return childrenRepo.addChild(child,familyId);
    }

    @Override
    public boolean updateChild(String lastName, String firstName, int cpr, int id) {
        return childrenRepo.updateChild(lastName,firstName,cpr,id);
    }

    @Override
    public boolean deleteChild(int id) {
        return childrenRepo.deleteChild(id);
    }

    @Override
    public Children findChildById(int childId, int familyId) {
        return childrenRepo.findChildById(childId,familyId);
    }

    @Override
    public List<Children> findChildrenByLastName(String lastName) {
        return childrenRepo.findChildrenByLastName(lastName);
    }
}
