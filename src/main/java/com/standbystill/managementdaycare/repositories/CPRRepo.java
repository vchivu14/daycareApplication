package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.CPR;

public interface CPRRepo {
    int addCPR(CPR cpr, int personId);

    CPR findCPRbyId(int cprId);

}
