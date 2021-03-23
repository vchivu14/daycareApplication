package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.CPR;
import com.standbystill.managementdaycare.repositories.CPRRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CPRCRUDServiceImpl implements CPRCRUDService {
    @Autowired
    CPRRepo cprRepo;

    @Override
    public int addCPR(CPR cpr, int personId) {
        return cprRepo.addCPR(cpr, personId);
    }

    @Override
    public CPR findCPRbyId(int cprId) {
        return cprRepo.findCPRbyId(cprId);
    }
}
