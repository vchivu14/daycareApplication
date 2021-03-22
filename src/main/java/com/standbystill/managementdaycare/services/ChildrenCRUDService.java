package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Child;
import com.standbystill.managementdaycare.entities.Family;

import java.util.List;

public interface ChildrenCRUDService {
    List<Child> fetchAll();

    List<Child> fetchChildrenForFamily(int familyId);

    Family fetchFamilyForChildren(int familyId);

    int addChild(Child child, int familyId);

    boolean updateChild(String lastName, String firstName, int cpr, int id);

    boolean deleteChild(int id);

    Child findChildById(int childId, int familyId);

    List<Child> findChildrenByLastName(String name);

}
