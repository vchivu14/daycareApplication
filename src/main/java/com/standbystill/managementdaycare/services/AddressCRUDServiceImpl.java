package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressCRUDServiceImpl implements AddressCRUDService {
    @Autowired AddressCRUDService addressCRUDService;


    @Override
    public int addAddress(Address address) {
        return addressCRUDService.addAddress(address);
    }
}
