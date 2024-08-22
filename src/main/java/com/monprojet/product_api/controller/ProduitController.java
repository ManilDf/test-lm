package com.monprojet.product_api.controller;

import com.monprojet.product_api.entity.Produit;
import com.monprojet.product_api.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }


}
