package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parent;

import java.util.List;

public interface ParentsRepo {
    List<Parent> fetchAll();

    List<Parent> fetchParentsForFamily(int familyId);

    Family fetchFamilyForParent(int familyId);

    int addParent(Parent parent, int familyId, int personId);

    boolean updateParent(String firstName, String lastName, int age, String email, int phone, int income, int personId);

    boolean deleteParent(int personId);

    Parent findParentById(int personId);

    List<Parent> findParentsByLastName(String name);
}
