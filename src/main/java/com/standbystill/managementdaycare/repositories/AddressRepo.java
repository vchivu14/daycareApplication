package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Address;

public interface AddressRepo {
    int addAddress(Address address, int tenantId);
}
