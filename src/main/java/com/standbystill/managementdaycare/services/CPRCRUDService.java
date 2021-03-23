package com.standbystill.managementdaycare.services;

import com.standbystill.managementdaycare.entities.CPR;

public interface CPRCRUDService {
    int addCPR(CPR cpr, int personId);

    CPR findCPRbyId(int cprId);
}
