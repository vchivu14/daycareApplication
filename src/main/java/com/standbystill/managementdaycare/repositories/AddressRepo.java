package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Address;
import com.standbystill.managementdaycare.entities.Child;

public interface AddressRepo {
    int addAddress(Address address);

    Address findAddressById(int id);
}
