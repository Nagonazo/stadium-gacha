package com.example.stadiumgacha;

import com.example.stadiumgacha.stadium.Stadium;
import com.example.stadiumgacha.stadium.StadiumRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StadiumRepository stadiumRepository;

    public DataInitializer(StadiumRepository stadiumRepository) {

        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public void run(String... args) {

        if (stadiumRepository.count() == 0) {

            System.out.println("Stadiumデータを登録します");

            List<Stadium> stadiums = List.of(
        //UR
        new Stadium("国立競技場", "東京都", "日本代表・各種大会", 68000, "UR", "OTHER"),

        //SSR
        new Stadium("メルカリスタジアム", "茨城県", "鹿島アントラーズ", 39095, "SSR", "J1"),
        new Stadium("豊田スタジアム", "愛知県", "名古屋グランパス", 42753, "SSR", "J1"),
        new Stadium("埼玉スタジアム2002", "埼玉県", "浦和レッズ", 62040, "SSR", "J1"),
        new Stadium("パナソニック スタジアム 吹田", "大阪府", "ガンバ大阪", 39694, "SSR", "J1"),
        new Stadium("ノエビアスタジアム神戸", "兵庫県", "ヴィッセル神戸", 27974, "SSR", "J1"),
        new Stadium("エディオンピースウイング広島", "広島県", "サンフレッチェ広島", 28407, "SSR", "J1"),
        new Stadium("サンガスタジアム by KYOCERA", "京都府", "京都サンガF.C.", 21269, "SSR", "J1"),
        new Stadium("三協フロンテア柏スタジアム", "千葉県", "柏レイソル", 15109, "SSR", "J1"),
        new Stadium("PEACE STADIUM Connected by SoftBank", "長崎県", "V・ファーレン長崎", 20268, "SSR", "J1"),

        //SR
        new Stadium("ユアテックスタジアム仙台", "宮城県", "ベガルタ仙台", 19694, "SR", "J2"),
        new Stadium("フクダ電子アリーナ", "千葉県", "ジェフユナイテッド千葉", 19470, "SR", "J2"),
        new Stadium("NACK5スタジアム大宮", "埼玉県", "RB大宮アルディージャ", 15500, "SR", "J2"),
        new Stadium("ニッパツ三ツ沢球技場", "神奈川県", "横浜FC", 15442, "SR", "J2"),
        new Stadium("IAIスタジアム日本平", "静岡県", "清水エスパルス", 19594, "SR", "J1"),
        new Stadium("ヤマハスタジアム（磐田）", "静岡県", "ジュビロ磐田", 15165, "SR", "J2"),
        new Stadium("サンプロ アルウィン", "長野県", "松本山雅FC", 20000, "SR", "J3"),
        new Stadium("長野Uスタジアム", "長野県", "AC長野パルセイロ", 15491, "SR", "J3"),
        new Stadium("金沢ゴーゴーカレースタジアム", "石川県", "ツエーゲン金沢", 10000, "SR", "J3"),
        new Stadium("アシックス里山スタジアム", "愛媛県", "FC今治", 5320, "SR", "J2"),
        new Stadium("ヨドコウ桜スタジアム", "大阪府", "セレッソ大阪", 24791, "SR", "J1"),
        new Stadium("ミクニワールドスタジアム北九州", "福岡県", "ギラヴァンツ北九州", 15300, "SR", "J3"),
        new Stadium("ベスト電器スタジアム", "福岡県", "アビスパ福岡", 21546, "SR", "J1"),
        new Stadium("駅前不動産スタジアム", "佐賀県", "サガン鳥栖", 24610, "SR", "J2"),

        new Stadium("日産スタジアム", "神奈川県", "横浜F・マリノス", 71624, "SR", "J1"),
        new Stadium("味の素スタジアム", "東京都", "FC東京・東京ヴェルディ", 47851, "SR", "J1"),
        new Stadium("デンカビッグスワンスタジアム", "新潟県", "アルビレックス新潟", 41684, "SR", "J2"),
        new Stadium("大和ハウス プレミストドーム", "北海道", "北海道コンサドーレ札幌", 38794, "SR", "J2"),
        new Stadium("Uvanceとどろきスタジアム by Fujitsu", "神奈川県", "川崎フロンターレ", 26827, "SR", "J1"),
        new Stadium("パロマ瑞穂スタジアム", "愛知県", "名古屋グランパス", 30000, "SR", "J1"),
        new Stadium("YANMAR HANASAKA STADIUM", "大阪府", "セレッソ大阪", 24481, "SR", "J1"),
        new Stadium("エコパスタジアム", "静岡県", "ジュビロ磐田", 50889, "SR", "J2"),

        //R
        new Stadium("富山県総合運動公園陸上競技場", "富山県", "カターレ富山", 25250, "R", "J2"),
        new Stadium("岐阜メモリアルセンターヒマラヤスタジアム岐阜", "岐阜県", "FC岐阜", 16000, "R", "J3"),
        new Stadium("えがお健康スタジアム", "熊本県", "ロアッソ熊本", 30300, "R", "J3"),
        new Stadium("JFE晴れの国スタジアム", "岡山県", "ファジアーノ岡山", 15479, "R", "J1"),
        new Stadium("町田GIONスタジアム", "東京都", "FC町田ゼルビア", 15320, "R", "J1"),
        new Stadium("レモンガススタジアム平塚", "神奈川県", "湘南ベルマーレ", 15380, "R", "J2"),
        new Stadium("鳴門・大塚スポーツパーク ポカリスエットスタジアム", "徳島県", "徳島ヴォルティス", 17924, "R", "J2"),
        new Stadium("NDソフトスタジアム山形", "山形県", "モンテディオ山形", 20812, "R", "J2"),

        //N
        new Stadium("ケーズデンキスタジアム水戸", "茨城県", "水戸ホーリーホック", 10152, "N", "J1"),
        new Stadium("札幌厚別公園競技場", "北海道", "北海道コンサドーレ札幌", 3865, "N", "J2"),
        new Stadium("プライフーズスタジアム", "青森県", "ヴァンラーレ八戸", 5000, "N", "J2"),
        new Stadium("ソユースタジアム", "秋田県", "ブラウブリッツ秋田", 20258, "N", "J2"),
        new Stadium("ハワイアンズスタジアムいわき", "福島県", "いわきFC", 5031, "N", "J2"),
        new Stadium("CITY FOOTBALL STATION", "栃木県", "栃木シティ", 5000, "N", "J2"),
        new Stadium("JIT リサイクルインク スタジアム", "山梨県", "ヴァンフォーレ甲府", 15859, "N", "J2"),
        new Stadium("藤枝総合運動公園サッカー場", "静岡県", "藤枝MYFC", 5010, "N", "J2"),
        new Stadium("クラサスドーム大分", "大分県", "大分トリニータ", 31000, "N", "J2"),
        new Stadium("いちご宮崎新富サッカー場", "宮崎県", "テゲバジャーロ宮崎", 5350, "N", "J2"),
        new Stadium("KUROKIRI STADIUM", "宮崎県", "テゲバジャーロ宮崎", 5000, "N", "J2"),
        new Stadium("とうほう・みんなのスタジアム", "福島県", "福島ユナイテッドFC", 21872, "N", "J3"),
        new Stadium("カンセキスタジアムとちぎ", "栃木県", "栃木SC", 24500, "N", "J3"),
        new Stadium("正田醤油スタジアム群馬", "群馬県", "ザスパ群馬", 15190, "N", "J3"),
        new Stadium("相模原ギオンスタジアム", "神奈川県", "SC相模原", 6428, "N", "J3"),
        new Stadium("平和堂HATOスタジアム", "滋賀県", "レイラック滋賀FC", 15000, "N", "J3"),
        new Stadium("東大阪市花園ラグビー場", "大阪府", "FC大阪", 26000, "N", "J3"),
        new Stadium("ロートフィールド奈良", "奈良県", "奈良クラブ", 30600, "N", "J3"),
        new Stadium("Axisバードスタジアム", "鳥取県", "ガイナーレ鳥取", 16500, "N", "J3"),
        new Stadium("維新みらいふスタジアム", "山口県", "レノファ山口FC", 15115, "N", "J3"),
        new Stadium("四国化成MEGLIOスタジアム", "香川県", "カマタマーレ讃岐", 22338, "N", "J3"),
        new Stadium("ニンジニアスタジアム", "愛媛県", "愛媛FC", 20384, "N", "J3"),
        new Stadium("GIKENスタジアム", "高知県", "高知ユナイテッドSC", 25000, "N", "J3"),
        new Stadium("白波スタジアム", "鹿児島県", "鹿児島ユナイテッドFC", 12584, "N", "J3"),
        new Stadium("沖縄県総合運動公園陸上競技場", "沖縄県", "FC琉球", 25000, "N", "J3")
    );

            stadiumRepository.saveAll(stadiums);

            System.out.println("Stadiumデータの登録が完了しました: " + stadiums.size() + "件");
        }
    }
}
