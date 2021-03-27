package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "teacher", schema = "daycare12")
public class Teacher implements Serializable {
    @Id
    @Column(name = "Staff_id")
    private int staffId;

    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private int phone;

    @OneToOne(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Class aClass;

    @Id
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Staff_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Staff staff;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Person_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Person person;

    public Teacher() {
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    @Override
    public String toString() {
        return "Teacher{" +
                ", staffId=" + staffId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
