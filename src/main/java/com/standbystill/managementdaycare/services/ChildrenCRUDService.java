package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Children;
import com.standbystill.managementdaycare.entities.Family;

import java.util.List;

public interface ChildrenCRUDService {
    List<Children> fetchAll();

    List<Children> fetchChildrenForFamily(int familyId);

    Family fetchFamilyForChildren(int familyId);

    int addChild(Children child, int familyId);

    boolean updateChild(String lastName, String firstName, int cpr, int id);

    boolean deleteChild(int id);

    Children findChildById(int childId, int familyId);

    List<Children> findChildrenByLastName(String name);

}
