package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Address;
import com.standbystill.managementdaycare.entities.Child;
import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parent;

import java.util.List;

public interface FamilyCRUDService {
    List<Family> fetchAll();

    int addFamily(Family family, int addressId);

    boolean updateFamily(Family family, int familyId);

    boolean deleteFamily(int familyId);

    Family findFamilyById(int familyId);

    List<Family> findFamilyByName(String name);

    List<Parent> findParentsForFamily(int familyId);

    List<Child> findChildrenForFamily(int familyId);
}
