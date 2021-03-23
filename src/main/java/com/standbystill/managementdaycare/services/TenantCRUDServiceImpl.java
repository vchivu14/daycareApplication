package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.Tenant;
import com.standbystill.managementdaycare.repositories.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantCRUDServiceImpl implements TenantCRUDService {
    @Autowired
    TenantRepo tenantRepo;

    @Override
    public int addTenant(Tenant tenant) {
        return tenantRepo.addTenant(tenant);
    }
}
