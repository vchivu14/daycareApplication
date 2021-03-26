package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Child;
import com.standbystill.managementdaycare.entities.Family;

import java.util.List;

public interface ChildrenCRUDService {
    List<Child> fetchAll();

    List<Child> fetchChildrenForFamily(int familyId);

    Family fetchFamilyForChildren(int familyId);

    void addChild(Child child, int familyId, int personId);

    boolean updateChild(Child child, int personId);

    boolean deleteChild(int personId);

    Child findChildById(int personId);

    List<Child> findChildrenByLastName(String name);

}
