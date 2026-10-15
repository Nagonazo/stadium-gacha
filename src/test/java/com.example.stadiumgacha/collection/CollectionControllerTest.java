package com.example.stadiumgacha.collection;

import com.example.stadiumgacha.stadium.Stadium;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CollectionController.class)
class CollectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CollectionService collectionService;

    @Test
    void コレクション取得APIは200を返す() throws Exception {

        Stadium stadium = new Stadium(
                "豊田スタジアム",
                "愛知県",
                "名古屋グランパス",
                42753,
                "SSR",
                "J1"
        );

        Collection collection = new Collection(stadium, 2);

        when(collectionService.getCollection())
                .thenReturn(List.of(collection));

        mockMvc.perform(get("/api/collection"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].stadium.name").value("豊田スタジアム"))
                .andExpect(jsonPath("$[0].quantity").value(2));
    }


    @Test
    void コレクションが空の場合は空の配列を返す() throws Exception {

        when(collectionService.getCollection())
                .thenReturn(List.of());

        mockMvc.perform(get("/api/collection"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
