package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person", schema = "daycare12")
public class Person implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CPR cpr;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CPR getCpr() {
        return cpr;
    }

    public void setCpr(CPR cpr) {
        this.cpr = cpr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", cpr=" + cpr +
                '}';
    }
}
