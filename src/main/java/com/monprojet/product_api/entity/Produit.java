package com.monprojet.product_api.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "produits")
public class Produit {

    @Id
    private String id;
    private String nom;
    private double prix;

}

