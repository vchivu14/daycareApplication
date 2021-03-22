package com.standbystill.managementdaycare.entities;

import java.io.Serializable;
import java.util.Objects;

public class ParentsId implements Serializable {
    private int id;
    private int familyId;

    public ParentsId() {
    }

    public ParentsId(int id, int familyId) {
        this.id = id;
        this.familyId = familyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentsId)) return false;
        ParentsId parentsId = (ParentsId) o;
        return getId() == parentsId.getId() && getFamilyId() == parentsId.getFamilyId();
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
