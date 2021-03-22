package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "Schedule", schema = "daycare12")
public class Schedule implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Schedule_has_Activity",
            joinColumns = {
                @JoinColumn(name = "Schedule_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "Activity_id", referencedColumnName = "id")}
    )
    private Collection<Activity> activities;

    @OneToOne(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Class aClass;

    public Schedule() {
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

    public Collection<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Collection<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
