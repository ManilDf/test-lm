package com.monprojet.product_api.controller;

import com.monprojet.product_api.entity.Produit;
import com.monprojet.product_api.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produits")
@AllArgsConstructor
public class ProduitController {

    private ProduitRepository produitRepository;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitRepository.findAllByOrderByNomAsc();
    }

}
