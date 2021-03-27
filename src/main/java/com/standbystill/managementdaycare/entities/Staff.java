package com.standbystill.managementdaycare.entities;

import javax.persistence.*;

@Entity
@Table(name = "Staff", schema = "daycare12")
public class Staff {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Position")
    private String position;
    @Column(name = "Salary")
    private int salary;

    public Staff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
