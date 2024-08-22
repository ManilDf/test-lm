package com.monprojet.product_api.controller;


import com.monprojet.product_api.entity.Produit;
import com.monprojet.product_api.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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

}

