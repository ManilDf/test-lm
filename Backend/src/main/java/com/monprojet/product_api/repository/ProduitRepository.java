package com.monprojet.product_api.repository;

import com.monprojet.product_api.entity.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProduitRepository extends MongoRepository<Produit, String> {
    List<Produit> findAllByOrderByNomAsc();
}

