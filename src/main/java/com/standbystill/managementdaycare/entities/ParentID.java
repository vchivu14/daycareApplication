package com.standbystill.managementdaycare.entities;

import java.io.Serializable;
import java.util.Objects;

public class ParentID implements Serializable {
    private int id;
    private int familyId;
    private int personId;

    public ParentID() {
    }

    public ParentID(int id, int familyId, int personId) {
        this.id = id;
        this.familyId = familyId;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentID)) return false;
        ParentID parentID = (ParentID) o;
        return getId() == parentID.getId() && getFamilyId() == parentID.getFamilyId() && getPersonId() == parentID.getPersonId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFamilyId(), getPersonId());
    }

}
