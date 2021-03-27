package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "person", schema = "daycare12")
public class Person implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CPR")
    private long cpr;
    @Column(name = "DOB")
    private Date dob;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Address_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Address address;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCpr() {
        return cpr;
    }

    public void setCpr(long cpr) {
        this.cpr = cpr;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", cpr=" + cpr +
                ", dob=" + dob +
                '}';
    }
}
