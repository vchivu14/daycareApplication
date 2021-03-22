package com.standbystill.managementdaycare.entities;

import java.io.Serializable;
import java.util.Objects;

public class ChildID implements Serializable {
    private int id;
    private int familyId;

    public ChildID() {
    }

    public ChildID(int id, int familyId) {
        this.id = id;
        this.familyId = familyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChildID)) return false;
        ChildID that = (ChildID) o;
        return getId() == that.getId() && getFamilyId() == that.getFamilyId();
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
