package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "activity", schema = "daycare12")
public class Activity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name")
    private int name;
    @Column(name = "Hours")
    private int hours;
    @Column(name = "Difficulty")
    private String difficulty;
    @Column(name = "Rating")
    private int rating;

    @ManyToMany(mappedBy = "activities", fetch = FetchType.LAZY)
    private Collection<Schedule> schedules;

    public Activity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Collection<Schedule> getSchedules() {
        return schedules;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name=" + name +
                ", hours=" + hours +
                ", difficulty='" + difficulty + '\'' +
                ", rating=" + rating +
                '}';
    }
}
