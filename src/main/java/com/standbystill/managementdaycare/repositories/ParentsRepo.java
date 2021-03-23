package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parent;

import java.util.List;

public interface ParentsRepo {
    List<Parent> fetchAll();

    List<Parent> fetchParentsForFamily(int familyId);

    Family fetchFamilyForParent(int familyId);

    int addParent(Parent parent, int familyId, int cprId);

    boolean updateParent(String lastName, String firstName, int cpr, int id);

    boolean deleteParent(int parentId);

    Parent findParentById(int parentId);

    List<Parent> findParentsByLastName(String name);
}
