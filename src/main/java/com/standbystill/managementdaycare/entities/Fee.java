package com.standbystill.managementdaycare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "fee", schema = "daycare12")
public class Fee implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Amount")
    private float amount;
    @Column(name = "Months")
    private int months;
    @Column(name = "Category")
    private String category;
    @Column(name = "Subsidy")
    private boolean subsidy;

    @OneToMany(mappedBy = "fee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Family> families;

    public Fee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", amount=" + amount +
                ", months=" + months +
                ", category='" + category + '\'' +
                '}';
    }
}
