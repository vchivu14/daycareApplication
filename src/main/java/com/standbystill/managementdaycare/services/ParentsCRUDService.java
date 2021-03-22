package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parent;

import java.util.List;

public interface ParentsCRUDService {
    List<Parent> fetchAll();

    List<Parent> fetchParentsForFamily(int familyId);

    Family fetchFamilyForParent(int familyId);

    int addParent(Parent parent, int familyId);

    boolean updateParent(String lastName, String firstName, int cpr, int id);

    boolean deleteParent(int parentId);

    Parent findParentById(int parentId);

    List<Parent> findParentsByLastName(String name);
}
