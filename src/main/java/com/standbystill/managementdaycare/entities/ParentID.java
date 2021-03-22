package com.standbystill.managementdaycare.entities;

import java.io.Serializable;
import java.util.Objects;

public class ParentID implements Serializable {
    private int id;
    private int familyId;

    public ParentID() {
    }

    public ParentID(int id, int familyId) {
        this.id = id;
        this.familyId = familyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentID)) return false;
        ParentID parentID = (ParentID) o;
        return getId() == parentID.getId() && getFamilyId() == parentID.getFamilyId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFamilyId());
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
}
