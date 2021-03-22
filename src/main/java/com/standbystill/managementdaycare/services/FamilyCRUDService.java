package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Children;
import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parents;

import java.util.List;

public interface FamilyCRUDService {
    List<Family> fetchAll();

    int addFamily(Family family);

    boolean updateFamily(String name, int familyId);

    boolean deleteFamily(int familyId);

    Family findFamilyById(int familyId);

    List<Family> findFamilyByName(String name);

    List<Parents> findParentsForFamily(int familyId);

    List<Children> findChildrenForFamily(int familyId);
}
