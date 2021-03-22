package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ParentID.class)
@Table(name = "parent", schema = "daycare12")
public class Parent implements Serializable {
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
    @Column(name = "Age")
    private int age;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private int phone;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Family_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Family family;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CPR", nullable = false)
    private CPR cpr;

    public Parent() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public CPR getCpr() {
        return cpr;
    }

    public void setCpr(CPR cpr) {
        this.cpr = cpr;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", familyId=" + familyId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", cpr=" + cpr +
                '}';
    }
}
