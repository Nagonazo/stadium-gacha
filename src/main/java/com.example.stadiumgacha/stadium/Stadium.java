package com.example.stadiumgacha.stadium;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Stadium {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private String prefecture;
    private String homeTeam;
    private int capacity;
    private String rarity;
    private String league;

    protected Stadium(){

    }

    public Stadium(
            String name,
            String prefecture,
            String homeTeam,
            int capacity,
            String rarity,
            String league) {

        this.name = name;
        this.prefecture = prefecture;
        this.homeTeam = homeTeam;
        this.capacity = capacity;
        this.rarity = rarity;
        this.league = league;
    }


    public String getName() {
        return name;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRarity() {
        return rarity;
    }

    public String getLeague() {
        return league;
    }
}
