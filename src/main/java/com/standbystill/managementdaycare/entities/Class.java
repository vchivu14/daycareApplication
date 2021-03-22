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
    @JoinColumn(name = "Teacher", nullable = false)
    private Teacher teacher;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Schedule_id", nullable = false)
    private Schedule schedule;

}
