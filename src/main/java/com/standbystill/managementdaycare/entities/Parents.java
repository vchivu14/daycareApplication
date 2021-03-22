package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ParentsId.class)
@Table(name = "parents", schema = "daycare1")
public class Parents implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Id
    @Column(name = "Family_id")
    private int familyId;

    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "CPR")
    private int cpr;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Family_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Family family;

    public Parents() {
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int parentId) {
        this.id = parentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Parents{" +
                "parentId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cpr=" + cpr +
                '}';
    }
}
