package com.example.stadiumgacha.collection;

import com.example.stadiumgacha.stadium.Stadium;
import com.example.stadiumgacha.stadium.StadiumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CollectionRepositoryTest {

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private StadiumRepository stadiumRepository;

    @Test
    void StadiumでCollectionを検索できる() {

        Stadium stadium = new Stadium(
                "豊田スタジアム",
                "愛知県",
                "名古屋グランパス",
                42753,
                "SSR",
                "J1"
        );

        stadiumRepository.save(stadium);

        Collection collection = new Collection(stadium, 2);

        collectionRepository.save(collection);

        Collection result = collectionRepository.findByStadium(stadium);

        assertEquals(2, result.getQuantity());
    }
}
