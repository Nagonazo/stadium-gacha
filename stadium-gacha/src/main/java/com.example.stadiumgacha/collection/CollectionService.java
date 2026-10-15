package com.example.stadiumgacha.collection;

import com.example.stadiumgacha.stadium.Stadium;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Comparator;


@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {

        this.collectionRepository = collectionRepository;
    }

    public void add(Stadium stadium) {

        Collection collection = collectionRepository.findByStadium(stadium);

        if (collection != null) {

            collection.setQuantity(collection.getQuantity() + 1);
            collectionRepository.save(collection);

        } else {

            Collection newCollection = new Collection(stadium, 1);
            collectionRepository.save(newCollection);
        }
    }

    public List<Collection> getCollection() {

        List<Collection> collection = collectionRepository.findAll();

        collection.sort(
            Comparator
            .comparingInt(
                (Collection item) -> rarityOrder(item.getStadium().getRarity())
            )
            .thenComparingInt(
                item -> leagueOrder(item.getStadium().getLeague())
            )
            .thenComparingInt(
                item -> prefectureOrder(item.getStadium().getPrefecture())
            )
        );

        return collection;
    }

    private int rarityOrder(String rarity){

        return switch (rarity){
            case "UR" -> 1;
            case "SSR" -> 2;
            case "SR" -> 3;
            case "R" -> 4;
            case "N" -> 5;
            default -> 99;
        };
    }

    private int leagueOrder(String league){

        return switch (league){
            case "OTHER" -> 1;
            case "J1" -> 2;
            case "J2" -> 3;
            case "J3" -> 4;
            default -> 99;
        };
    }

    private int prefectureOrder(String prefecture) {

    return switch (prefecture) {
        case "北海道" -> 1;
        case "青森県" -> 2;
        case "岩手県" -> 3;
        case "宮城県" -> 4;
        case "秋田県" -> 5;
        case "山形県" -> 6;
        case "福島県" -> 7;
        case "茨城県" -> 8;
        case "栃木県" -> 9;
        case "群馬県" -> 10;
        case "埼玉県" -> 11;
        case "千葉県" -> 12;
        case "東京都" -> 13;
        case "神奈川県" -> 14;
        case "新潟県" -> 15;
        case "富山県" -> 16;
        case "石川県" -> 17;
        case "福井県" -> 18;
        case "山梨県" -> 19;
        case "長野県" -> 20;
        case "岐阜県" -> 21;
        case "静岡県" -> 22;
        case "愛知県" -> 23;
        case "三重県" -> 24;
        case "滋賀県" -> 25;
        case "京都府" -> 26;
        case "大阪府" -> 27;
        case "兵庫県" -> 28;
        case "奈良県" -> 29;
        case "和歌山県" -> 30;
        case "鳥取県" -> 31;
        case "島根県" -> 32;
        case "岡山県" -> 33;
        case "広島県" -> 34;
        case "山口県" -> 35;
        case "徳島県" -> 36;
        case "香川県" -> 37;
        case "愛媛県" -> 38;
        case "高知県" -> 39;
        case "福岡県" -> 40;
        case "佐賀県" -> 41;
        case "長崎県" -> 42;
        case "熊本県" -> 43;
        case "大分県" -> 44;
        case "宮崎県" -> 45;
        case "鹿児島県" -> 46;
        case "沖縄県" -> 47;
        default -> 99;
    };
    }
}
