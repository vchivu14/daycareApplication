package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "family", schema = "daycare1")
public class Family implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "fees")
    private float fees;

    @OneToMany(mappedBy = "familyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Parents> parents;

    @OneToMany(mappedBy = "familyId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Children> children;

    public Family() {

    }

    public void addParents(Parents parent) {
        parents.add(parent);
    }

    public int getId() {
        return id;
    }

    public void setId(int familyId) {
        this.id = familyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }

    public Collection<Parents> getParents() {
        return parents;
    }

    public void setParents(Collection<Parents> parents) {
        this.parents = parents;
    }

    public Collection<Children> getChildren() {
        return children;
    }

    public void setChildren(Collection<Children> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Family{" +
                "childId=" + id +
                ", name='" + name + '\'' +
                ", fees=" + fees +
                '}';
    }
}
