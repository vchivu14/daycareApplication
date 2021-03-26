package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Address;

public interface AddressRepo {
    int addAddress(Address address);

    Address findAddressById(int id);

    boolean updateAddress(Address address, int id);
}
