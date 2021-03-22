package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CPR", schema = "daycare12")
public class CPR implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Number")
    private int number;

    @OneToOne(mappedBy = "cpr", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Parent parent;

    @OneToOne(mappedBy = "cpr", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Child child;

    public CPR() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "CPR{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
