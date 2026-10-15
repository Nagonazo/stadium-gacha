package com.example.stadiumgacha.api;

import com.example.stadiumgacha.gacha.GachaService;
import com.example.stadiumgacha.stadium.Stadium;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GachaController {

    private final GachaService gachaService;

    public GachaController(GachaService gachaService) {
        this.gachaService = gachaService;
    }

    @GetMapping("/api/gacha")
    public Stadium draw() {
        return gachaService.draw();
    }

    @GetMapping("/api/gacha/ten")
    public List<Stadium> drawTen() {
        return gachaService.drawTen();
    }
}
