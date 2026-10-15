package com.example.stadiumgacha.collection;

import com.example.stadiumgacha.stadium.Stadium;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Stadium stadium;

    private int quantity;

    public Collection() {
    }

    public Collection(Stadium stadium, int quantity) {
        this.stadium = stadium;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
