package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Person;

public interface PersonCRUDService {
    int addPerson(Person person, int addressId);
}
