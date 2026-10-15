package com.example.stadiumgacha.collection;

import com.example.stadiumgacha.stadium.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

    Collection findByStadium(Stadium stadium);
}
