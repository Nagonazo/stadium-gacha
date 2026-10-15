package com.example.stadiumgacha.gacha;


import com.example.stadiumgacha.collection.CollectionService;
import com.example.stadiumgacha.stadium.Stadium;
import com.example.stadiumgacha.stadium.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GachaService {

    private final Random random = new Random();

    private final StadiumRepository stadiumRepository;

    private final CollectionService collectionService;

    public GachaService(StadiumRepository stadiumRepository, CollectionService collectionService) {

        this.stadiumRepository = stadiumRepository;
        this.collectionService = collectionService;
    }

    public Stadium draw() {

        List<Stadium> stadiums = stadiumRepository.findAll();

        return drawFromStadiums(stadiums);
    }

    public List<Stadium> drawTen() {

        List<Stadium> stadiums = stadiumRepository.findAll();
        List<Stadium> results = new ArrayList<>();

        // 1～9回目
        for (int i = 0; i < 9; i++) {
            results.add(drawFromStadiums(stadiums));
        }

        // 10回目はSR以上確定
        results.add(drawSrOrHigher(stadiums));

        return results;
    }

    private Stadium drawFromStadiums(List<Stadium> stadiums) {

        int roll = random.nextInt(100);

        String targetRarity;

        if (roll < 1) {
            targetRarity = "UR";

        } else if (roll < 5) {
            targetRarity = "SSR";

        } else if (roll < 20) {
            targetRarity = "SR";

        } else if (roll < 45) {
            targetRarity = "R";

        } else {
            targetRarity = "N";
        }

        List<Stadium> candidates = stadiums.stream()
                .filter(stadium ->
                        stadium.getRarity().equals(targetRarity))
                .toList();

        int index = random.nextInt(candidates.size());

        Stadium result = candidates.get(index);

        collectionService.add(result);

        return result;
    }

    private Stadium drawSrOrHigher(List<Stadium> stadiums) {

        int roll = random.nextInt(20);

        String targetRarity;

        if (roll == 0) {
            targetRarity = "UR";

        } else if (roll < 5) {
            targetRarity = "SSR";

        } else {
            targetRarity = "SR";
        }

        List<Stadium> candidates = stadiums.stream()
                .filter(stadium ->
                        stadium.getRarity().equals(targetRarity))
                .toList();

        int index = random.nextInt(candidates.size());

        Stadium result = candidates.get(index);

        collectionService.add(result);

        return result;
    }
}
