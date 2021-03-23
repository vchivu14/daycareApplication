package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Address;

public interface AddressCRUDService {
    int addAddress(Address address, int tenantId);
}
