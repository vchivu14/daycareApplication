package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parent;

import java.util.List;

public interface ParentsRepo {
    List<Parent> fetchAll();

    List<Parent> fetchParentsForFamily(int familyId);

    Family fetchFamilyForParent(int familyId);

    void addParent(Parent parent, int familyId, int personId);

    boolean updateParent(Parent parent, int personId);

    boolean deleteParent(int personId);

    Parent findParentById(int personId);

    List<Parent> findParentsByLastName(String name);
}
