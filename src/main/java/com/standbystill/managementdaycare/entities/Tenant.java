package com.standbystill.managementdaycare.entities;

import javax.persistence.*;

@Entity
@Table(name = "tenant", schema = "daycare12")
public class Tenant {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "tenant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    public Tenant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

}
