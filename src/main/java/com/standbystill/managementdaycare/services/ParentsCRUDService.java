package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parents;

import java.util.List;

public interface ParentsCRUDService {
    List<Parents> fetchAll();

    List<Parents> fetchParentsForFamily(int familyId);

    Family fetchFamilyForParent(int familyId);

    int addParent(Parents parent, int familyId);

    boolean updateParent(String lastName, String firstName, int cpr, int id);

    boolean deleteParent(int parentId);

    Parents findParentById(int parentId);

    List<Parents> findParentsByLastName(String name);
}
