package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Class", schema = "daycare12")
public class Class implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Occupancy")
    private int occupancy;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Teacher_Staff_id", referencedColumnName = "Staff_id", nullable = false)
    private Teacher teacher;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Schedule_id", nullable = false)
    private Schedule schedule;

    public Class() {
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

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
