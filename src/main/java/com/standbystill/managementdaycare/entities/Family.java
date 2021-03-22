package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "family", schema = "daycare12")
public class Family implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "Registration")
    private Date registration;
    @Column(name = "Phone")
    private int phone;
    @Column(name = "Subsidy")
    private boolean subsidy;

    @OneToMany(mappedBy = "familyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Parent> parents;

    @OneToMany(mappedBy = "familyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Child> children;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Fee_id")
    private Fee fee;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Address", nullable = false)
    private Address address;

    public Family() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isSubsidy() {
        return subsidy;
    }

    public void setSubsidy(boolean subsidy) {
        this.subsidy = subsidy;
    }

    public Collection<Parent> getParents() {
        return parents;
    }

    public void setParents(Collection<Parent> parents) {
        this.parents = parents;
    }

    public Collection<Child> getChildren() {
        return children;
    }

    public void setChildren(Collection<Child> children) {
        this.children = children;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registration=" + registration +
                ", phone=" + phone +
                ", subsidy=" + subsidy +
                ", fee=" + fee +
                ", address=" + address +
                '}';
    }
}
