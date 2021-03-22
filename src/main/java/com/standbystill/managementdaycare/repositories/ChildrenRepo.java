package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Children;
import com.standbystill.managementdaycare.entities.Family;

import java.util.List;

public interface ChildrenRepo {
    List<Children> fetchAll();

    List<Children> fetchChildrenForFamily(int familyId);

    Family fetchFamilyForChildren(int familyId);

    int addChild(Children child, int familyId);

    boolean updateChild(String lastName, String firstName, int cpr, int id);

    boolean deleteChild(int childId);

    Children findChildById(int childId, int familyId);

    List<Children> findChildrenByLastName(String lastName);
}
