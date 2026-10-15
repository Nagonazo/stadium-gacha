package com.example.stadiumgacha.collection;

import com.example.stadiumgacha.stadium.Stadium;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CollectionServiceTest {

    @Test
    void 初めて追加したStadiumのquantityは1になる() {

        CollectionRepository collectionRepository = mock(CollectionRepository.class);

        Stadium stadium = new Stadium(
                "豊田スタジアム",
                "愛知県",
                "名古屋グランパス",
                42753,
                "SSR",
                "J1"
        );

        when(collectionRepository.findByStadium(stadium))
                .thenReturn(null);

        CollectionService collectionService =
                new CollectionService(collectionRepository);

        collectionService.add(stadium);

        verify(collectionRepository).save(argThat(collection -> 
                collection.getQuantity() == 1));
    }


    @Test
    void 同じStadiumをもう一度追加するとquantityが2になる() {

        CollectionRepository collectionRepository = mock(CollectionRepository.class);

        Stadium stadium = new Stadium(
                "豊田スタジアム",
                "愛知県",
                "名古屋グランパス",
                42753,
                "SSR",
                "J1"
        );

        Collection existingCollection = new Collection(stadium, 1);

        when(collectionRepository.findByStadium(stadium))
                .thenReturn(existingCollection);

        CollectionService collectionService =
                new CollectionService(collectionRepository);

        collectionService.add(stadium);

        verify(collectionRepository).save(argThat(collection ->
                collection.getQuantity() == 2
        ));
    }


    @Test
    void 別のStadiumを追加すると新しいCollectionとして保存される() {

        CollectionRepository collectionRepository = mock(CollectionRepository.class);

        Stadium stadium = new Stadium(
                "国立競技場",
                "東京都",
                "日本代表",
                68000,
                "UR",
                "J1"
        );

        when(collectionRepository.findByStadium(stadium))
                .thenReturn(null);

        CollectionService collectionService =
                new CollectionService(collectionRepository);

        collectionService.add(stadium);

        verify(collectionRepository).save(argThat(collection ->
                collection.getStadium() == stadium
                        && collection.getQuantity() == 1
        ));
    }


}
