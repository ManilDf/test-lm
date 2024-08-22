package com.monprojet.product_api.controller;


import com.monprojet.product_api.entity.Produit;
import com.monprojet.product_api.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProduitController.class)
public class ProduitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProduitRepository produitRepository;

    @Test
    void getAllProduits() throws Exception {

        List<Produit> produits = List.of(
                new Produit("1", "Produit 1", 10.0),
                new Produit("2", "Produit 2", 20.0)
        );
        when(produitRepository.findAllByOrderByNomAsc()).thenReturn(produits);

        mockMvc.perform(MockMvcRequestBuilders.get("/produits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nom").value("Produit 1"));
    }

    @Test
    void createProduit() throws Exception {

        Produit produit = new Produit("17", "Produit 17", 30.0);
        when(produitRepository.save(produit)).thenReturn(produit);

        mockMvc.perform(MockMvcRequestBuilders.post("/produits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"17\", \"nom\": \"Produit 17\", \"prix\": 30.0}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Produit 17"));
    }


}

