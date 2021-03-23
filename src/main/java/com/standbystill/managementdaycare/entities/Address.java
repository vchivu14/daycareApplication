package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address", schema = "daycare12")
public class Address implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Street")
    private String street;
    @Column(name = "Number")
    private int number;
    @Column(name = "City")
    private String city;
    @Column(name = "Zipcode")
    private int zipcode;
    @Column(name = "Country")
    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tenant_id", insertable=false, updatable=false)
    private Tenant tenant;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Family family;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Teacher teacher;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Tenant getTenant() {
        return tenant;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city=" + city +
                ", zipcode=" + zipcode +
                ", country='" + country + '\'' +
                '}';
    }
}
