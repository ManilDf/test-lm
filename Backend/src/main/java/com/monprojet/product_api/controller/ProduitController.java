package com.monprojet.product_api.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monprojet.product_api.entity.Produit;
import com.monprojet.product_api.repository.ProduitRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produits")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {

    private ProduitRepository produitRepository;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitRepository.findAllByOrderByNomAsc();
    }

    @PostMapping
    public Produit createProduit(@Validated @RequestBody Produit produit) {
        return produitRepository.save(produit);
    }


}
